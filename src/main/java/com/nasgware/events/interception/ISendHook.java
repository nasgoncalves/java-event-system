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
public interface ISendHook<A extends IAction> extends ISend<A> {
    
    void onSend(IProvider<A> handler, A action);
    
}
