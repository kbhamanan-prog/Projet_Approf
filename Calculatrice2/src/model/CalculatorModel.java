/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Control.CalculatorControler;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;




/**
 *
 * @author kbham
 */
public class CalculatorModel implements CalculatorModelInterface {
    
    //création de l'accumulateur
      private Stack<Double> accu= new Stack<>();
      private CalculatorControler controler;
    
      public CalculatorModel(CalculatorControler controler){
          this.controler=controler;
      }
   // méthode pour additionner les deux derniers éléments de l'accumulateur
    @Override
    public void add() {
        if(accu.size()>=2){
            double x = accu.pop();
            double y = accu.pop();
            accu.push(x+y);
            updateView();
        }
    }
 // méthode pour soustraire les deux derniers éléments de l'accumulateur
    @Override
    public void substract() {
        if(accu.size()>=2){
            double x = accu.pop();
            double y = accu.pop();
            accu.push(y-x);
            updateView();
        }
       
    }
    
 // méthode pour multiplier les deux derniers éléments de l'accumulateur
    @Override
    public void multiply() {
        if(accu.size()>=2){
            double x = accu.pop();
            double y = accu.pop();
            accu.push(x*y);
            updateView();
        }    
    }

     // méthode pour prendre l'opposé du dernier élément de l'accumulateur
    @Override
    public void opposite() {
        if(accu.size()>=1){
            double x = accu.pop();
            accu.push(-x);
            updateView();
        }
    }
     // méthode pour prendre rajouter un élément dans l'accumulateur
    @Override
    public void push(double x) {
        accu.push(x);
        updateView();
    }

// méthode pour prendre récupérer le dernier élément de l'accumulateur
    @Override
    public double pop() {
        return accu.pop();
    }

 // méthode pour supposer le dernier élément de l'accumulateur
    @Override
    public void drop() {
       accu.pop();
       updateView();
    }

// méthode pour échanger les deux derniers éléments de l'accumulateur
    @Override
    public void swap() {
        double x=accu.pop();
        double y=accu.pop();
        accu.push(x);
        accu.push(y);
        updateView();
    }
    
// méthode pour vider l'accumulateur
    @Override
    public void clear() {
        accu.clear();
        updateView();
    }
    
    private void updateView() {
        List<Double> list = new ArrayList<>(accu);
        controler.change(list);
    }

    @Override
    public void divide() {
        if (accu.size()>=2){
            double x=accu.pop();
            double y=accu.pop();
            if(x!=0){
                accu.push(y/x);
            }
            else{
                accu.push(y);
                accu.push(x);
            }
        }
        
    }
    
}

