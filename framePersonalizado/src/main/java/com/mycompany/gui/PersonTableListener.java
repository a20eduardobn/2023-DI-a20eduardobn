package com.mycompany.gui;

import java.util.EventListener;

public interface PersonTableListener extends EventListener {
    public void rowDeleted(int row);
}
