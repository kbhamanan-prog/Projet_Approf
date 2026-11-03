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
public interface CalculatriceModelInterface {
    abstract void add(Stack<Double> pile);
    abstract void substract(Stack<Double> pile);
    abstract void multiply(Stack<Double> pile);
    abstract void opposite(Stack<Double> pile) ;
    abstract void push(Stack<Double> pile, double x);
    abstract double pop(Stack<Double> pile) ;
    abstract void drop(Stack<Double> pile) ;
    abstract void swap(Stack<Double> pile);
    abstract void clear(Stack<Double> pile);
    }



