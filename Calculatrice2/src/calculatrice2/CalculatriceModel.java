/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculatrice2;

import java.util.Stack;




/**
 *
 * @author kbham
 */
public class CalculatriceModel implements CalculatriceModelInterface {
    
    //création de l'accumulateur
      private  Stack<Double> accu= new Stack<>();
    
   // méthode pour additionner les deux derniers éléments de l'accumulateur
    @Override
    public void add(Stack<Double> pile) {
       double x = pile.pop();
       double y = pile.pop();
       pile.push(x+y);
    }
 // méthode pour soustraire les deux derniers éléments de l'accumulateur
    @Override
    public void substract(Stack<Double> pile) {
       double x = pile.pop();
       double y = pile.pop();
       pile.push(x-y);
    }
    
 // méthode pour multiplier les deux derniers éléments de l'accumulateur
    @Override
    public void multiply(Stack<Double> pile) {
       double x = pile.pop();
       double y = pile.pop();
       pile.push(x*y);
    }

     // méthode pour prendre l'opposé du dernier élément de l'accumulateur
    @Override
    public void opposite(Stack<Double> pile) {
        double x = pile.pop();
        pile.push(-x);
    }
     // méthode pour prendre rajouter un élément dans l'accumulateur
    @Override
    public void push(Stack<Double> pile, double x) {
        pile.push(x);
    }

// méthode pour prendre récupérer le dernier élément de l'accumulateur
    @Override
    public double pop(Stack<Double> pile) {
        double x = pile.pop();
        return x;
    }

 // méthode pour supposer le dernier élément de l'accumulateur
    @Override
    public void drop(Stack<Double> pile) {
       pile.pop();
    }

// méthode pour échanger les deux derniers éléments de l'accumulateur
    @Override
    public void swap(Stack<Double> pile) {
        double x=pile.pop();
        double y=pile.pop();
        pile.push(x);
        pile.push(y);
    }
    
// méthode pour vider l'accumulateur
    @Override
    public void clear(Stack<Double> pile) {
        pile.clear();
    }
    
}

