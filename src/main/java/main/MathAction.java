/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.nasgware.events.events.Action;
import com.nasgware.events.handlers.IActionHandler;

/**
 *
 * @author Nuno Gonçalves
 */
public class MathAction extends Action {

    public static final String TYPE = MathAction.class.getName();
    private final Operation operation;
    private final int num1;
    private final int num2;

    public static enum Operation {

        SUM, SUB;
    }

    public MathAction(final Operation operation, 
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
