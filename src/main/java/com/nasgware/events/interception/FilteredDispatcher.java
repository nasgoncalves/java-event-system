/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.interception;

import com.nasgware.events.dispatchers.IDispatcher;
import com.nasgware.events.events.IAction;
import com.nasgware.events.provider.IProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Nuno Gonçalves
 */
public class FilteredDispatcher<A extends IAction> implements IDispatcher<A> {

    private final String type;
    
    private IFilter<A> filter;

    public FilteredDispatcher(final String type) {
        this.type = type;
    }
    
    public void on(final IProvider<A> handler, final A action) {
        try {
            onFilter(handler, action);
        } catch (BrokenChainException ex) {
            return;
        }
        
        if (action.getType().equals(getHandledType())) {
            handler.on(action);
        }
        
    }
    
    public void onFilter(final IProvider<A> handler, final A action) 
            throws BrokenChainException {
        filter.filter(action);
    }
    
    protected boolean set(final IFilter<A> filter) {
        this.filter = filter;
        return true;
    }
 
    public String getHandledType() {
        return type;
    }
    
}
