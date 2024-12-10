package org.example.command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    private static final int GRID_SIZE = 8;
    private Pixel[][] pixels = new Pixel[GRID_SIZE][GRID_SIZE];
    private int cursorX = 0;
    private int cursorY = 0;

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                Pixel pixel = new Pixel();
                pixels[y][x] = pixel;
                gridPane.add(pixel, x, y);
            }
        }

        Button generateCodeButton = new Button("Create Code");
        generateCodeButton.setOnAction(e -> new GenerateCodeCommand(pixels).execute());

        VBox root = new VBox(gridPane, generateCodeButton);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        // Request focus on the scene to capture key events
        scene.getRoot().requestFocus();

        updateCursor();
    }

    private void handleKeyPress(KeyCode keyCode) {
        switch (keyCode) {
            case UP -> new MoveCursorUpCommand(this).execute();
            case DOWN -> new MoveCursorDownCommand(this).execute();
            case LEFT -> new MoveCursorLeftCommand(this).execute();
            case RIGHT -> new MoveCursorRightCommand(this).execute();
            case SPACE -> new TogglePixelCommand(this).execute();
        }
    }

    public void moveCursor(int dx, int dy) {
        cursorX = Math.max(0, Math.min(GRID_SIZE - 1, cursorX + dx));
        cursorY = Math.max(0, Math.min(GRID_SIZE - 1, cursorY + dy));
        updateCursor();
    }

    public void togglePixel() {
        pixels[cursorY][cursorX].toggle();
    }

    private void updateCursor() {
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                pixels[y][x].setCursor(x == cursorX && y == cursorY);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}