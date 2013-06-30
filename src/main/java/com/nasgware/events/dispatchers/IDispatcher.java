/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.dispatchers;

import com.nasgware.events.events.IAction;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author juza
 */
public interface IDispatcher<A extends IAction> {
    
    void on(IProvider<A> provider, A action);
    
    String getHandledType();
    
}
