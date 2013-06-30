/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.nasgware.events.dispatchers.VetoDispatcher;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author Nuno Gonçalves
 */
public class VetoMathDispatcher extends VetoDispatcher<MathVetoAction> {

    public VetoMathDispatcher() {
        super(MathVetoAction.TYPE);
    }

    @Override
    public void on(IProvider<MathVetoAction> handler, MathVetoAction action) {
        if (action.num1 == 2) {
            action.veto();
            System.out.println("::VETO::");
        }
        super.on(handler, action);
    }
    
    
    
}
