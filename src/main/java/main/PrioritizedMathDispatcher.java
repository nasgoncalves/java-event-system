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
public class PrioritizedMathDispatcher extends Dispatcher<PrioritizedMathAction> {

    public PrioritizedMathDispatcher() {
        super(PrioritizedMathAction.TYPE);
    }
 
}
