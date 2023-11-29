package com.mycompany.gui;

import java.util.EventListener;

public interface ToolbarListener extends EventListener {
    public void toolbarActionPerformed(ToolbarEvent te);
}
