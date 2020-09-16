package com.ditryx.fourgame;

import java.util.Scanner;

public class FourGame {

    private Field field;
    private Scanner userInput;
    private Player[] players;
    private Rules rules;
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private int totalMoves =0;
    private boolean isRunning = true;

    public FourGame() {
        players = new Player[2];
        field = new Field(this.ROWS, this.COLUMNS);
        rules = new Rules(field);
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

        userInput = new Scanner(System.in);
    }

    public void run(){

        initPlayers();
        field.initField();

        while (isRunning){

            System.out.println("Player 1 [" + players[0].getName() + "] - Choose column (1-"+COLUMNS+"): ");
            processCheck();
            userInputTurn(players[0].getSignature());
            this.totalMoves = this.totalMoves + 1;


            System.out.println("Player 1 [" + players[1].getName() + "] - Choose column (1-"+COLUMNS+"): ");
            processCheck();
            userInputTurn(players[1].getSignature());
            this.totalMoves = this.totalMoves + 1;

        }
    }

    private void userInputTurn(String player) {

        boolean process = true;

        while (process) {

            if (!userInput.hasNextInt()) {
                //if the user has entered the non-integer, then warn the user
                System.out.println("Wrong, [" + player + "]! Choose column (1-"+COLUMNS+")");
                userInput.next();
            }
            else {

                int number = userInput.nextInt(); //take user input as integer

                if (number > 0 && number <= COLUMNS) {

                    if (rules.isValidColumn(number)) {
                        System.out.println("Wrong, [" + player + "]! The column " + number
                                + " is already full, try a different column number");
                    } else {
                        field.updateField(number, player);
                        rules.isConnected(number,player);
                        process = false; // close

                    }
                } else {
                    System.out.println("Wrong, [" + player + "]! Choose column (1-"+COLUMNS+")");
                }

            }

        }

    }

    public void processCheck(){
        field.printField();
        rules.checkDraw(this.totalMoves);
    }

    public void initPlayers(){
            players[0].setName("Red");
            players[0].setSignature("R");

            players[1].setName("Green");
            players[1].setSignature("G");
    }

}
