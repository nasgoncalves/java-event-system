/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.events;

import com.nasgware.events.structures.Priority;

/**
 *
 * @author Nuno Gonçalves
 */
public class PriorityAction implements IAction, Priority {

    private final String type;
    private final int priority;

    public PriorityAction(final String type, final int priority) {
        this.type = type;
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }
    
}
