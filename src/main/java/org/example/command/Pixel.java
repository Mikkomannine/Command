package org.example.command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pixel extends Rectangle {
    private boolean on = false;

    public Pixel() {
        super(30, 30);
        setFill(Color.WHITE);
        setStroke(Color.BLACK);
    }

    public void toggle() {
        on = !on;
        setFill(on ? Color.BLACK : Color.WHITE);
    }

    public boolean isOn() {
        return on;
    }

    public void setCursor(boolean isCursor) {
        setStroke(isCursor ? Color.RED : Color.BLACK);
    }
}