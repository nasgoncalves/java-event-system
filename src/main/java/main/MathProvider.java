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
public class MathProvider extends Provider<MathAction>
        implements MathAction.AddHandler {

    public MathProvider() {
        super(MathAction.TYPE);
    }

    @Override
    public void on(MathAction action) {
        action.dispatch((MathAction.AddHandler) this);
    }

    public void onSum(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
