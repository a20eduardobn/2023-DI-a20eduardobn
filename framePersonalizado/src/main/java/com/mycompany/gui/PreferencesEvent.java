package com.mycompany.gui;

import java.util.EventObject;

public class PreferencesEvent extends EventObject {

    private final String user;
    private final String passwd;
    private final int port;

    public PreferencesEvent(Object source, String user, String passwd, int port) {
        super(source);
        this.user=user;
        this.passwd=passwd;
        this.port=port;
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    }

    public int getPort() {
        return port;
    }
}
