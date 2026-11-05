/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import View.CalculatorGUI;

import java.util.List;
import model.CalculatorModel;

/**
 *
 * @author kbham
 */
public class CalculatorControler implements CalculatorControlerInterface {
    private CalculatorModel model = new CalculatorModel(this);
    private CalculatorGUI view;
    
    public CalculatorControler(CalculatorGUI view){
        this.view=view;
    }
    @Override
    public void change(String accu) {
        String[] list=accu.split(";");
        if(list.length>1 && !list[1].isEmpty()){
                    model.push(Double.parseDouble(list[1]));
                }
        switch (list[0]) {
            case "+":
                model.add();
                break;
            case "-":
                model.substract();
                break;
            case "X":
                model.multiply();
                break;
            case "÷":
                model.divide();
                break;
            case "PUSH":
                break;
            case "CLEAR":
                model.clear();
                break;
            case "+/-":
                model.opposite();
                break;
            default:
                if (view != null) {
                    view.change(accu);
                }
                break;
        }    
    }

    @Override
    public void change(List<Double> StackData) {
        view.change(StackData);
    }

   
    
}
