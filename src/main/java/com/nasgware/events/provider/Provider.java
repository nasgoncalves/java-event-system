/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.provider;

import com.nasgware.events.events.IAction;
import com.nasgware.events.handlers.IActionHandler;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Nuno Gonçalves
 */
public abstract class Provider<A extends IAction> implements IProvider<A> {

    private final String handledType;
    private final List<IActionHandler> handlers;

    public Provider(final String handledType) {
        this.handledType = handledType;
        handlers = new CopyOnWriteArrayList<IActionHandler>();
    }
    
    protected boolean register(final IActionHandler handler) {
        return handlers.add(handler);
    }
    
    public IActionHandler[] gethandlers() {
        return handlers.toArray(new IActionHandler[handlers.size()]);
    }

    public String getHandledType() {
        return handledType;
    }

    public abstract void on(A action);
    
}
