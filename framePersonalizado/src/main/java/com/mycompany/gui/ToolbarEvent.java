package com.mycompany.gui;


public class ToolbarEvent {
    private Object source;
    private String actionCommand;
    public ToolbarEvent(Object source){
        this.source=source;
    }

    public Object getSource() {
        return source;
    }

    public void setActionCommand(String actionCommand) {
        this.actionCommand = actionCommand;
    }

    public String getActionCommand() {
        return actionCommand;
    }
}
