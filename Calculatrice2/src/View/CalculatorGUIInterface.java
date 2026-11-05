package View;

import java.util.List;
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author kbham
 */
public interface CalculatorGUIInterface {
    abstract void affiche();
    abstract void change(String accu);
    abstract void change(List<Double> StackData);
}

