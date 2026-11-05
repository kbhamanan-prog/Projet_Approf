package View;

import Control.CalculatorControler;
import java.util.List;
import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author sophi
 */
public class CalculatorGUI extends Application implements CalculatorGUIInterface {
    public boolean virgule=true; // booléan nécessaire pour avoir une seuke virgule
    public CalculatorControler controler = new CalculatorControler(this);
    private String Value = ""; 
    // Attribut global pour que les méthodes change() puissent modifier l'écran
    
    private TextField[] ecranLignes = new TextField[5];

    public CalculatorGUI() {
    }

    @Override
    public void start(Stage primaryStage) {
        
        // Création des boutons de la calculatrice
        Button btn0 = new Button("0");
        btn0.setOnAction(e->{
            Value+="0";
            System.out.println("0");
        });
        Button btn1 = new Button("1");
        btn1.setOnAction(e->{
            Value+="1";
            updateScreen(Value);
                });
        Button btn2 = new Button("2");
        btn2.setOnAction(e->{
            Value+="2";
            updateScreen(Value);
                });
        Button btn3 = new Button("3");
        btn3.setOnAction(e->{
            Value+="3";
            updateScreen(Value);
                });
        Button btn4 = new Button("4");
        btn4.setOnAction(e->{
            Value+="4";
            updateScreen(Value);
                });
        Button btn5 = new Button("5");
        btn5.setOnAction(e->{
            Value+="5";
            updateScreen(Value);
                });
        Button btn6 = new Button("6");
        btn6.setOnAction(e->{
            Value+="6";
            updateScreen(Value);
                });
        Button btn7 = new Button("7");
        btn7.setOnAction(e->{
            Value+="7";
            updateScreen(Value);
                });
        Button btn8 = new Button("8");
        btn8.setOnAction(e->{
            Value+="8";
            updateScreen(Value);
                });
        Button btn9 = new Button("9");
        btn9.setOnAction(e->{
            Value+="9";
            updateScreen(Value);
                });
        Button btnadd = new Button("+");
        btnadd.setOnAction(e->{
            change("+;"+Value);
            Value="";
            virgule=true;
            updateScreen(Value);
                });
        Button btnsou = new Button("-");
        btnsou.setOnAction(e->{
            change("-;"+Value);
            Value="";
            virgule=true;
            updateScreen(Value);
                });
        Button btnmul = new Button("X");
        btnmul.setOnAction(e->{
            change("X;"+Value);
            Value="";
            virgule=true;
            updateScreen(Value);
                });
        Button btndiv = new Button("÷");
        btndiv.setOnAction(e->{
            change("÷;"+Value);
            Value="";
            virgule=true;
            updateScreen(Value);
                });
        Button btndrop = new Button("Effacer");
        btndrop.setOnAction(e->{
            change("CLEAR");
            Value="";
            virgule=true;
            updateScreen(Value);
                });
        Button btnpush = new Button("OK");
        btnpush.setOnAction(e->{
            change("PUSH;"+Value);
            Value="";
            virgule=true;
            updateScreen(Value);
                });
        Button btnpop = new Button("Rep");
        btnpop.setOnAction(e->{
            change("DROP");
            Value="";
            virgule=true;
            updateScreen(Value);
                });
        Button btnvir = new Button(",");
        btnvir.setOnAction(e->{
            if(virgule){
                virgule = false;
                Value+=".";
                updateScreen(Value);updateScreen(Value);
            }
                });
        Button btnplusmoins = new Button("+/-");
        btnplusmoins.setOnAction(e->{
            change("+/-;"+Value);
            Value="";
            virgule=true;
            updateScreen(Value);
                });
        

        Button[] listeBoutons = {
            btn0, btnvir, btnplusmoins, btnadd,
            btn1, btn2, btn3, btnsou,
            btn4, btn5, btn6, btnmul,
            btn7, btn8, btn9, btndiv,
            btnpop, btndrop, btnpush
        };

        // Création de la grille pour contenir les boutons
        GridPane grille = new GridPane();
        grille.setHgap(8); 
        grille.setVgap(8); 
        grille.setPadding(new Insets(10)); 

        // Force les 4 colonnes à faire 25% de largeur
        for (int c = 0; c < 4; c++) {
            ColumnConstraints colContrainte = new ColumnConstraints();
            colContrainte.setPercentWidth(25);
            grille.getColumnConstraints().add(colContrainte);
        }

        // Force les 5 lignes à faire 20% de hauteur
        for (int r = 0; r < 5; r++) {
            RowConstraints ligneContrainte = new RowConstraints();
            ligneContrainte.setPercentHeight(20);
            grille.getRowConstraints().add(ligneContrainte);  
        }

        // Remplissage de la grille (boutons du haut)
        grille.add(btnpush, 0, 0);
        grille.add(btnpop, 1, 0);
        grille.add(btndrop, 2, 0, 2, 1);
        
        btnpush.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        btnpop.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        btndrop.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        btnpush.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnpop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btndrop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Remplissage du pavé numérique
        int i = 0;
        for (int ligne = 0; ligne <= 3; ligne++) {
            for (int col = 0; col <=3; col++) {
                if (i < listeBoutons.length) {
                    grille.add(listeBoutons[i], col, 4 - ligne);
                    listeBoutons[i].setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                    listeBoutons[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    i++;
                }
            }
        }

        // Création de l'écran de 5 lignes
        VBox vboxEcran = new VBox(2);
        for (int k = 0; k <= 4; k++) {
            ecranLignes[k] = new TextField();
            ecranLignes[k].setAlignment(Pos.CENTER_RIGHT);
            ecranLignes[k].setEditable(false);
            ecranLignes[k].setMouseTransparent(true);
            vboxEcran.getChildren().add(ecranLignes[k]);
        }

        // VBox finale
        VBox root = new VBox(10); 
        root.setPadding(new Insets(10)); 
        root.getChildren().addAll(vboxEcran, grille);
        VBox.setVgrow(grille, Priority.ALWAYS);

        Scene scene = new Scene(root, 350, 550);
        primaryStage.setTitle("Ma calculette RPN");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // LA MÉTHODE MAIN DOIT ÊTRE ICI POUR QUE NETBEANS TROUVE LA CLASSE PRINCIPALE
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void affiche() {
    }

    @Override
    public void change(String accu) {
        
        controler.change(accu);
    }

    @Override
    public void change(List<Double> StackData) {
        for (int i = 0; i < ecranLignes.length-1; i++) {
            if (i < StackData.size()) {
                ecranLignes[3-i].setText(String.valueOf(StackData.get(StackData.size()-i-1)));
            } else {
                ecranLignes[3-i].setText("");
            }
        }
    }
    public void updateScreen(String Value){
        ecranLignes[4].setText(Value);
    }
}