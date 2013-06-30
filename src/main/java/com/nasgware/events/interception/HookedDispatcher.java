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
public class HookedDispatcher<A extends IAction> implements IDispatcher<A> {
    
    private final String type;
    private final List<ISendHook<A>> sends;
    private final List<IReceiveHook<A>> receives;

    public HookedDispatcher(final String type) {
        this.type = type;
        sends = new CopyOnWriteArrayList<ISendHook<A>>();
        receives = new CopyOnWriteArrayList<IReceiveHook<A>>();
    }
    
    public void on(final IProvider<A> handler, final A action) {
        onReceive(handler, action);
        
        if (action.getType().equals(getHandledType())) {
            handler.on(action);
        }
        
        onSend(handler, action);
    }
    
    protected boolean add(final IReceiveHook hook) {
        return receives.add(hook);
    }
    
    protected boolean add(final ISendHook hook) {
        return sends.add(hook);
    }
    
    public void onReceive(final IProvider<A> handler, final A action) {
        for (IReceiveHook hook : receives) {
            hook.onReceive(handler, action);
        }
    }
    
    public void onSend(final IProvider<A> handler, final A action) {
        for (ISendHook hook : sends) {
            hook.onSend(handler, action);
        }
    }

    public String getHandledType() {
        return type;
    }
    
}
