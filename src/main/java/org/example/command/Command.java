package org.example.command;

public interface Command {
    void execute();
}

class MoveCursorUpCommand implements Command {
    private final PixelArtEditor editor;

    public MoveCursorUpCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursor(0, -1);
    }
}

class MoveCursorDownCommand implements Command {
    private final PixelArtEditor editor;

    public MoveCursorDownCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursor(0, 1);
    }
}

class MoveCursorLeftCommand implements Command {
    private final PixelArtEditor editor;

    public MoveCursorLeftCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursor(-1, 0);
    }
}

class MoveCursorRightCommand implements Command {
    private final PixelArtEditor editor;

    public MoveCursorRightCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursor(1, 0);
    }
}

class TogglePixelCommand implements Command {
    private final PixelArtEditor editor;

    public TogglePixelCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.togglePixel();
    }
}
