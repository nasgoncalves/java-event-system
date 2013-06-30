/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.provider;

import com.nasgware.events.events.IAction;
import com.nasgware.events.handlers.IActionHandler;

/**
 *
 * @author juza
 */
public interface IProvider<A extends IAction> {
    
    void on(A action);
    
    IActionHandler[] gethandlers();
    
    String getHandledType();
    
}
