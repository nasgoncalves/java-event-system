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
public class PrioritizedMathProvider extends Provider<PrioritizedMathAction>
        implements PrioritizedMathAction.AddHandler {

    public PrioritizedMathProvider() {
        super(PrioritizedMathAction.TYPE);
    }

    @Override
    public void on(PrioritizedMathAction action) {
        action.dispatch((PrioritizedMathAction.AddHandler) this);
    }

    public void onSum(int p, int num1, int num2) {
        
        
        
        System.out.println(p + " : " + num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
