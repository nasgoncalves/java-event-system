
package com.nasgware.events.interception;

/**
 *
 * @author Nuno Gonçalves
 */
public class BrokenChainException extends Exception {

    public BrokenChainException() {
        super();
    }
    
    public BrokenChainException(String message) {
        super(message);
    }

}
