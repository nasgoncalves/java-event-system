/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.channel;

import com.nasgware.events.dispatchers.IDispatcher;
import com.nasgware.events.events.IAction;
import com.nasgware.events.handlers.IActionHandler;
import com.nasgware.events.provider.IProvider;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Nuno Gonçalves
 */
public class Channel implements IChannel {

    private final ExecutorService executer;
    private final List<IDispatcher> dispatchers;
    private final List<IProvider<?>> providers;

    public Channel() {
        executer = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors());
        dispatchers = new CopyOnWriteArrayList<IDispatcher>();
        providers = new CopyOnWriteArrayList<IProvider<?>>();
    }

    public <A extends IAction> void on(final A action) {
        executer.submit(new Worker(action));
    }

    public boolean add(final IDispatcher dispatcher) {
        return dispatchers.add(dispatcher);
    }

    public boolean remove(final IDispatcher dispatcher) {
        return dispatchers.remove(dispatcher);
    }

    public boolean add(final IProvider<?> provider) {
        return providers.add(provider);
    }

    public boolean remove(final IProvider<?> provider) {
        return providers.remove(provider);
    }

    public IDispatcher[] getDispatchers() {
        return dispatchers.toArray(new IDispatcher[dispatchers.size()]);
    }

    public IProvider<?>[] getProviders() {
        return providers.toArray(new IProvider<?>[providers.size()]);
    }
    
    public void shutdown() {
        executer.shutdown();
        try {
            executer.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            
        }
        executer.shutdownNow();
    }

    private final class Worker<A extends IAction> implements Runnable {

        private final A action;

        public Worker(final A action) {
            this.action = action;
        }

        public void run() {

            final List<IProvider<A>> lproviders = new CopyOnWriteArrayList<IProvider<A>>();

            for (final IProvider<?> provider : providers) {
                if (action.getType().equals(provider.getHandledType())) {
                    lproviders.add((IProvider<A>) provider);
                }
            }

            final List<IDispatcher<A>> ldispatchers = new CopyOnWriteArrayList<IDispatcher<A>>();

            for (final IDispatcher<?> dispatcher : dispatchers) {
                if (action.getType().equals(dispatcher.getHandledType())) {
                    ldispatchers.add((IDispatcher<A>) dispatcher);
                }
            }

            for (final IDispatcher<A> dispatcher : ldispatchers) {
                for (final IProvider<A> provider : lproviders) {
                    dispatcher.on(provider, action);
                }
            }

        }
    }
    
}
