/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.nasgware.events.dispatchers.Dispatcher;

/**
 *
 * @author Nuno Gonçalves
 */
public class MathDispatcher extends Dispatcher<MathAction> {

    public MathDispatcher() {
        super(MathAction.TYPE);
    }
 
}
