/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.dispatchers;

import com.nasgware.events.events.IAction;
import com.nasgware.events.events.VetoAction;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author Nuno Gonçalves
 */
public class VetoDispatcher<A extends IAction> implements IDispatcher<A> {

    private final String type;
    
    public VetoDispatcher(final String type) {
        this.type = type;
    }
    
    public void on(final IProvider<A> handler, final A action) {
        if (action instanceof VetoAction) {
            if (((VetoAction)action).isVetoed()) {
                return;
            }
        }
        
        if (action.getType().equals(getHandledType())) {
            handler.on(action);
        }
    }

    public String getHandledType() {
        return type;
    }
    
}
