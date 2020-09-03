package me.mattstudios.mfhelper.form;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

public final class TestToolWindow {

    private JPanel panel;

    public TestToolWindow(final ToolWindow toolWindow) {
        panel.setBackground(toolWindow.getComponent().getBackground());
    }

    public JPanel getPanel() {
        return panel;
    }
}
