/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.events;

/**
 *
 * @author Nuno Gonçalves
 */
public class Action implements IAction {

    private final String type;

    public Action(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
}
