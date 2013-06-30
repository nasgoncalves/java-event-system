/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.interception;

import com.nasgware.events.events.IAction;

/**
 *
 * @author Nuno Gonçalves
 */
public abstract class Filter<A extends IAction> implements IFilter<A> {

    private final IFilter<A> filter;

    public Filter(final IFilter<A> filter) {
        this.filter = filter;
    }

    public void runNext(final A action) throws BrokenChainException {
        if (!(null == filter)) {
            filter.filter(action);
        }
    }
    
}
