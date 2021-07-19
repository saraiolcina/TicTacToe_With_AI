package ticTacToeWithAI;

import java.util.*;

public class AI extends Player{

    static char [][] boardMatrix = new char [3][3];

    public AI(char [][] boardMatrix){

        this.boardMatrix=boardMatrix;

    }

    //AI makes its move. Using Random Class
    void aiMakeAMove(char turn, int emptyCounter){

        System.out.println("Making move level \"easy\"");

        boolean flag= true;

        Random rnd= new Random();

        do{
            if(emptyCounter==0){
                flag =false;
            }

            int rnd1=rnd.nextInt(3);
            int rnd2=rnd.nextInt(3);

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(boardMatrix[rnd1][rnd2]==' '){
                        boardMatrix[rnd1][rnd2]=turn;
                        flag=false;
                    }
                }
            }

        }while (flag);

    }

}
