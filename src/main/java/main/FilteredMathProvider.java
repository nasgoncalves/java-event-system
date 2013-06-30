/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.nasgware.events.provider.Provider;

/**
 *
 * @author Nuno Gonçalves
 */
public class FilteredMathProvider extends Provider<MathFilteredAction>
        implements MathFilteredAction.AddHandler {

    public FilteredMathProvider() {
        super(MathFilteredAction.TYPE);
    }

    @Override
    public void on(MathFilteredAction action) {
        action.dispatch((MathFilteredAction.AddHandler) this);
    }

    public void onSum(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }

}
