/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.nasgware.events.events.VetoAction;
import com.nasgware.events.handlers.IActionHandler;

/**
 *
 * @author Nuno Gonçalves
 */
public class MathVetoAction extends VetoAction {

    public static final String TYPE = MathVetoAction.class.getName();
    private final Operation operation;
    public final int num1;
    public final int num2;

    public static enum Operation {
        SUM, SUB;
    }

    public MathVetoAction(final Operation operation, 
            final int num1, final int num2) {
        super(TYPE);
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
    }

    public static interface AddHandler extends IActionHandler {
        void onSum(final int num1, final int num2);
    }

    protected void dispatch(AddHandler handler) {
        if (operation.equals(Operation.SUM)) {
            handler.onSum(num1, num2);
        }
    }
    
}
