/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.handlers;

import com.nasgware.events.events.IEvent;

/**
 *
 * @author juza
 */
public interface IEventHandler<E extends IEvent> extends IHandler {
    
    void on(E event);
    
}
