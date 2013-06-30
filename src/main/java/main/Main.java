package main;

import com.nasgware.events.channel.IChannel;
import com.nasgware.events.channel.PriorityChannel;
import com.nasgware.events.dispatchers.IDispatcher;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author Nuno Gonçalves
 */
public class Main {

    public static void main(String[] args) {
        
        final long start = System.nanoTime();
        
        IChannel channel = new PriorityChannel();
        IDispatcher<PrioritizedMathAction> dispatcher = new PrioritizedMathDispatcher();
        IProvider<PrioritizedMathAction> provider = new PrioritizedMathProvider();
        
        channel.add(dispatcher);
        channel.add(provider);
        
        for (int i = 0; i<20; i++) {
            final int a = i;
            channel.on(new PrioritizedMathAction(
                    a, PrioritizedMathAction.Operation.SUM, a, 5));
        }
        
        channel.shutdown();
        
        final long end = System.nanoTime();
        
        System.out.println("Time (seconds) taken is " + (end - start) / 1.0e9);
        
    }
}
