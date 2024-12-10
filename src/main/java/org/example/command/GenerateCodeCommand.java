package org.example.command;

public class GenerateCodeCommand implements Command {
    private final Pixel[][] pixels;

    public GenerateCodeCommand(Pixel[][] pixels) {
        this.pixels = pixels;
    }

    @Override
    public void execute() {
        StringBuilder code = new StringBuilder("int[][] pixelArt = {\n");
        for (Pixel[] row : pixels) {
            code.append("    {");
            for (Pixel pixel : row) {
                code.append(pixel.isOn() ? "1" : "0").append(", ");
            }
            code.setLength(code.length() - 2); // Remove trailing comma and space
            code.append("},\n");
        }
        code.setLength(code.length() - 2); // Remove trailing comma and newline
        code.append("\n};");
        System.out.println(code);
    }
}
