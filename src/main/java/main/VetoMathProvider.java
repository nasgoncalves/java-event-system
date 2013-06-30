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
public class VetoMathProvider extends Provider<MathVetoAction>
        implements MathVetoAction.AddHandler {

    public VetoMathProvider() {
        super(MathVetoAction.TYPE);
    }

    @Override
    public void on(MathVetoAction action) {
        action.dispatch((MathVetoAction.AddHandler) this);
    }

    public void onSum(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
