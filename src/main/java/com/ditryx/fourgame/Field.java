package com.ditryx.fourgame;

public class Field {

    private String fieldTemplate[][];

    private int row;
    private int column;

    private String emptyCell = " ";

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
        this.fieldTemplate = new String[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String[][] getField() {
        return fieldTemplate;
    }

    public String getEmptyCell() {
        return emptyCell;
    }

    public void initField(){
        for (int i = 0; i < fieldTemplate.length; i++) {
            for (int j = 0; j <fieldTemplate[i].length ; j++) {
                fieldTemplate[i][j]= emptyCell;
            }
        }
    }


    public void updateField(int column, String playerSignature){
        for (int j = this.fieldTemplate.length - 1; j >= 0; j--) {

            if (this.fieldTemplate[j][column - 1].equals(emptyCell)) {
                this.fieldTemplate[j][column - 1] = playerSignature;
                break;
            }
        }
    }

    public void printField(){
        for (int i = 0; i < this.fieldTemplate.length; i++) {
            System.out.print("|");
            for (int j = 0; j < this.fieldTemplate[i].length; j++) {
                System.out.print(this.fieldTemplate[i][j] + "|");
            }

            System.out.println("");
        }
    }

}
