package main;

import com.nasgware.events.channel.Channel;
import com.nasgware.events.channel.IChannel;
import com.nasgware.events.channel.PriorityChannel;
import com.nasgware.events.dispatchers.IDispatcher;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author Nuno Gonçalves
 */
public class MainHook {

    public static void main(String[] args) {
        
        final long start = System.nanoTime();
        
        IChannel channel = new Channel();
        IDispatcher<MathAction> dispatcher = new HookedMathDispatcher();
        IProvider<MathAction> provider = new MathProvider();
        
        channel.add(dispatcher);
        channel.add(provider);
        
        for (int i = 0; i<20; i++) {
            channel.on(new MathAction(MathAction.Operation.SUM, 5, 5));
        }
        
        channel.shutdown();
        
        final long end = System.nanoTime();
        
        System.out.println("Time (seconds) taken is " + (end - start)/1.0e9);
        
    }
}
