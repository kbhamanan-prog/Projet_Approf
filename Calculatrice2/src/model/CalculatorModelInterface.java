/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Stack;

/**
 *
 * @author kbham
 */
public interface CalculatorModelInterface {
    abstract void add();
    abstract void substract();
    abstract void multiply();
    abstract void divide();
    abstract void opposite() ;
    abstract void push(double x);
    abstract double pop() ;
    abstract void drop() ;
    abstract void swap();
    abstract void clear();
    }



