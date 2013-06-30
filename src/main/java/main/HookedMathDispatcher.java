/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.nasgware.events.events.IAction;
import com.nasgware.events.interception.HookedDispatcher;
import com.nasgware.events.interception.IReceiveHook;
import com.nasgware.events.provider.IProvider;

/**
 *
 * @author Nuno Gonçalves
 */
public class HookedMathDispatcher extends HookedDispatcher<MathAction> {

    public HookedMathDispatcher() {
        super(MathAction.TYPE);
        
        this.add(new IReceiveHook() {

            public void onReceive(IProvider handler, IAction action) {
                System.out.println("A new event has arrived!");
            }
            
        });
        
    }
    
}
