/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.nasgware.events.events.Action;
import com.nasgware.events.handlers.IActionHandler;
import com.nasgware.events.structures.Priority;

/**
 *
 * @author Nuno Gonçalves
 */
public class PrioritizedMathAction extends Action implements Priority {

    public static final String TYPE = PrioritizedMathAction.class.getName();
    private final Operation operation;
    private final int num1;
    private final int num2;
    
    private final int priority;

    public static enum Operation {
        SUM, SUB;
    }

    public PrioritizedMathAction(final int priority, final Operation operation, 
            final int num1, final int num2) {
        super(TYPE);
        this.priority = priority;
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
    }

    public static interface AddHandler extends IActionHandler {
        void onSum(int p, int num1, int num2);
    }

    protected void dispatch(AddHandler handler) {
        if (operation.equals(Operation.SUM)) {
            handler.onSum(getPriority(), num1, num2);
        }
    }
    
    public int getPriority() {
        return priority;
    }
}
