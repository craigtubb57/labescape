package com.craigtubb;

public class LabToEscape {

    private String input;
    private int x;
    private int y;
    private int rows;
    private int cols;
    private String output;

    public String getInput() {
        return input;
    }
    
    public String getInputHTML() {
        return input.replaceAll("\n", "<br>");
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public String getOutput() {
        return output;
    }
    
    public String getOutputHTML() {
        return output.replaceAll("\n", "<br>");
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
