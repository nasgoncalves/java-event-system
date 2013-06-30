/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.interception;

import com.nasgware.events.events.IAction;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author juza
 */
public interface IReceiveHook<A extends IAction> extends IReceive<A> {
    
    void onReceive(IProvider<A> handler, A action);
    
}
