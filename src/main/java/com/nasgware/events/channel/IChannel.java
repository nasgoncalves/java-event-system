package com.nasgware.events.channel;

import com.nasgware.events.dispatchers.IDispatcher;
import com.nasgware.events.events.IAction;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author Nuno Gonçalves
 */
public interface IChannel {
    
    <A extends IAction> void on(A action);
    
    boolean add(IDispatcher dispatcher);
    
    boolean remove(IDispatcher dispatcher);
    
    boolean add(IProvider<?> provider);
    
    boolean remove(IProvider<?> provider);
    
    IDispatcher[] getDispatchers();
    
    IProvider<?>[] getProviders();
    
    void shutdown();
    
}
