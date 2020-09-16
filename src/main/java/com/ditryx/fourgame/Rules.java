package com.ditryx.fourgame;

public class Rules {

    private Field field;
    private String fieldTemplate[][];

    public Rules(Field field) {
        this.field = field;
        this.fieldTemplate = field.getField();
    }

    public boolean isValidColumn(int column){

        int count = 0;

        for (int j = this.fieldTemplate.length - 1; j >= 0; j--) {

            if (!this.fieldTemplate[j][column - 1].equals(field.getEmptyCell())) {
                count++;
            }
        }

        return count == this.fieldTemplate.length;
    }

    public void checkDraw(int totalMoves) {

        int totalCells = this.field.getColumn() * this.field.getRow();

        if (totalMoves == totalCells) {
            System.out.println("Draw!");
            System.out.println("GAME OVER!");
            System.exit(0);
        }

    }

    public void checkWin(int count, String player){
        int total = 4;

        if (count >= total) {
            System.out.println("Player: ["+player+"] wins!");
            System.out.println("GAME OVER!");
            field.printField();
            System.exit(0);
        }
    }

    public void isConnected(int columnNumber, String player) {

        for (int x = 0; x < this.fieldTemplate.length; x++) {

            int count = 0;
            int i = columnNumber;

            //Horizontal
            while (i < field.getColumn() && fieldTemplate[x][i].equals(player)) {
                count++;
                i++;
            }
            i = columnNumber - 1;

            while (i >= 0 && fieldTemplate[x][i].equals(player)) {
                count++;
                i--;
            }

            checkWin(count,player);

            //vertical
            count = 0;
            int j = x;
            while (j < field.getRow() && this.fieldTemplate[j][columnNumber - 1].equals(player)) {
                count++;
                j++;
            }

            checkWin(count,player);

            //First diagonal
            count = 0;
            i = x;
            j = columnNumber;
            while (i < field.getRow() && j < field.getColumn() && this.fieldTemplate[i][j].equals(player)) {
                count++;
                i++;
                j++;
            }
            i = x - 1;
            j = columnNumber - 1;
            while (i >= 0 && j >= 0 && this.fieldTemplate[i][j].equals(player)) {
                count++;
                i--;
                j--;
            }

            checkWin(count,player);

            //second diagonal
            count = 0;
            i = x;
            j = columnNumber - 1;
            while (i < field.getRow() && j >= 0 && this.fieldTemplate[i][j].equals(player)) {
                count++;
                i++;
                j--;
            }
            i = x - 1;
            j = (columnNumber - 1) + 1;
            while (i >= 0 && j < field.getColumn() && this.fieldTemplate[i][j].equals(player)) {
                count++;
                i--;
                j++;
            }

            checkWin(count,player);

        }
    }


}
