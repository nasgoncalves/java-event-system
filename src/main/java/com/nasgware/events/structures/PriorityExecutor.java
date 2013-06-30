
package com.nasgware.events.structures;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Nuno Gonçalves
 */
public class PriorityExecutor extends ThreadPoolExecutor {

    public PriorityExecutor(final int nThreads) {
        super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>(11,
                new PriorityTaskComparator()));
    }

    public PriorityExecutor(final int nThreads,
            final ThreadFactory threadFactory) {
        super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>(11,
                new PriorityTaskComparator()), threadFactory);
    }

    public PriorityExecutor(final int nThreads,
            final RejectedExecutionHandler handler) {
        super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>(11,
                new PriorityTaskComparator()), handler);
    }

    public PriorityExecutor(final int nThreads,
            final ThreadFactory threadFactory,
            final RejectedExecutionHandler handler) {
        super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>(11,
                new PriorityTaskComparator()), threadFactory, handler);
    }

    @Override
    public Future<?> submit(final Runnable task) {
        if (task == null) {
            throw new NullPointerException();
        }

        final RunnableFuture<Object> ftask = newTaskFor(task, null);
        execute(ftask);

        return ftask;
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(final Callable<T> callable) {
        if (callable instanceof Priority) {
            return new PriorityTask<T>(((Priority) callable).getPriority(),
                    callable);
        } else {
            return new PriorityTask<T>(0, callable);
        }
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(final Runnable runnable,
            final T value) {
        if (runnable instanceof Priority) {
            return new PriorityTask<T>(((Priority) runnable).getPriority(),
                    runnable, value);
        } else {
            return new PriorityTask<T>(0, runnable, value);
        }
    }

    private static final class PriorityTask<T>
            extends FutureTask<T>
            implements Comparable<PriorityTask<T>> {

        private final int priority;

        public PriorityTask(final int priority, final Callable<T> tCallable) {
            super(tCallable);
            this.priority = priority;
        }

        public PriorityTask(final int priority, final Runnable runnable,
                final T result) {
            super(runnable, result);
            this.priority = priority;
        }

        public int compareTo(final PriorityTask<T> o) {
            final long diff = o.priority - priority;
            return Long.signum(diff);
        }
    }

    private static class PriorityTaskComparator
            implements Comparator<Runnable> {

        @Override
        public int compare(final Runnable left, final Runnable right) {
            int leftPriority = 0;
            int rightPriority = 0;

            if (left instanceof Priority) {
                leftPriority = ((Priority) left).getPriority();
            }

            if (right instanceof Priority) {
                rightPriority = ((Priority) right).getPriority();
            }

            return Long.signum(leftPriority - rightPriority);
        }
        
    }
    
}
