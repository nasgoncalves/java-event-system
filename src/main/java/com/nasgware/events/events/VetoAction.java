/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasgware.events.events;

import com.nasgware.events.structures.Veto;

/**
 *
 * @author Nuno Gonçalves
 */
public class VetoAction implements IAction, Veto {
    
    private final String type;
    private volatile boolean veto;
    
    public VetoAction(final String type) {
        this.type = type;
        this.veto = false;
    }

    public String getType() {
        return type;
    }

    public void veto() {
        veto = true;
    }

    public boolean isVetoed() {
        return true == veto;
    }
    
}
