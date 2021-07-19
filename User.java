package ticTacToeWithAI;

import java.util.Scanner;

public class User extends Player{

    static Scanner input = new Scanner(System.in);
    static char [][] boardMatrix = new char [3][3];

    public User(char [][] boardMatrix){

        this.boardMatrix=boardMatrix;

    }

    //Make a move
    void makeAMove(char turn){

        boolean flag= true;

        do{
            try{
                System.out.println("Enter the coordinates: ");

                int n1=input.nextInt();
                int n2=input.nextInt();

                if(n1<1 || n2<1 ||n1>3 ||n2>3){
                    System.out.println("Coordinates should be from 1 to 3!");
                }else if(boardMatrix[n1-1][n2-1]=='X' || boardMatrix[n1-1][n2-1]=='O'){
                    System.out.println("This cell is occupied! Choose another one!");
                }else {
                    boardMatrix[n1-1][n2-1]=turn;
                    flag=false;
                }

            }catch(Exception e){
                System.out.println("You should enter numbers!");
                input.next();
                input.next();
            }

        }while(flag);

    }

}
