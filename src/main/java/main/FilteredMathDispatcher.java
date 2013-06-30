/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.nasgware.events.interception.BrokenChainException;
import com.nasgware.events.interception.Filter;
import com.nasgware.events.interception.FilteredDispatcher;
import com.nasgware.events.interception.IFilter;

/**
 *
 * @author Nuno Gonçalves
 */
public class FilteredMathDispatcher 
    extends FilteredDispatcher<MathFilteredAction> {

    public FilteredMathDispatcher() {
        super(MathFilteredAction.TYPE);
    
        IFilter<MathFilteredAction> filter1 = new Filter<MathFilteredAction>(null) {

            public void filter(MathFilteredAction action) 
                    throws BrokenChainException {
                
                System.out.println("Filter 1!");
                
                runNext(action);
            }
            
        };
        
        IFilter<MathFilteredAction> filter2 = new Filter<MathFilteredAction>(filter1) {

            public void filter(MathFilteredAction action) 
                    throws BrokenChainException {
                
                System.out.println("Filter 2!");
                
                runNext(action);
            }
            
        };
        
        set(filter2);
    }
    
}
