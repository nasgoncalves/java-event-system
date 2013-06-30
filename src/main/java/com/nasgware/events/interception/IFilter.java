/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.interception;

import com.nasgware.events.events.IAction;

/**
 *
 * @author juza
 */
public interface IFilter<A extends IAction> {
    
    void filter(A action) throws BrokenChainException;
    
    void runNext(A action) throws BrokenChainException;
    
}
