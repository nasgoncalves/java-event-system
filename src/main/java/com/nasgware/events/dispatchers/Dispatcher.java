/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.dispatchers;

import com.nasgware.events.events.IAction;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author Nuno Gonçalves
 */
public class Dispatcher<A extends IAction> implements IDispatcher<A> {

    private final String type;
    
    public Dispatcher(final String type) {
        this.type = type;
    }
    
    public void on(final IProvider<A> handler, final A action) {
        if (action.getType().equals(getHandledType())) {
            handler.on(action);
        }
    }

    public String getHandledType() {
        return type;
    }
    
}
