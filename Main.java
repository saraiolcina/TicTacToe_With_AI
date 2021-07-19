package ticTacToeWithAI;

import java.util.*;

public class Main {

    static char [][] boardMatrix = new char [3][3];
    static int emptyCounter;
    static boolean winnerX=false;
    static boolean winnerO=false;
    static Scanner input= new Scanner(System.in);
    static char turn='X';

    public enum Players{
        USER,
        EASY,
        MEDIUM,
        HARD
    }


    public static void main(String[] args) {

        boolean flag= true;
        do{

            Players inputX= null;
            Players inputO=null;

            try{
                winnerX=false;
                winnerO=false;

                System.out.println("Input command: ");
                String startExit= input.nextLine();
                String startExitArr [] = startExit.split(" ");      //with this we add a a word on each position.


                if(startExitArr[0].equalsIgnoreCase("exit")){
                    System.exit(0);     //ends program
                }else if(startExitArr[0].equalsIgnoreCase("start")){

                    inputX= Players.valueOf(startExitArr[1].toUpperCase());
                    inputO=Players.valueOf(startExitArr[2].toUpperCase());

                    startGame(inputX, inputO);

                }else if(startExitArr.length !=3){
                    System.out.println("Bad parameters!");
                }

            }catch (Exception exception){
                System.out.println("Bad parameters!");
            }

        }while(flag);

    }

    //Start game
    static void startGame(Players inputX, Players inputO){

        //Convert parameters into array so we can fetch through the loop
        Players [] playersArray ={inputX,inputO};

        //Create objects
        Board board = new Board(boardMatrix, winnerX, winnerO);
        HashMap <String, Object> playersList = new HashMap<>();     //here we store the objects according to two keys (playerX and playerO)
        User user=null;
        AI aiEasy=null;

        for(int i=0;i<playersArray.length;i++){

            switch (playersArray[i]){
                case USER:
                    user = new User(boardMatrix);
                    playersList.put("player"+(i+1), user);
                    break;
                case EASY:
                    aiEasy = new AI(boardMatrix);
                    playersList.put("player"+(i+1), aiEasy);
                    break;
                case MEDIUM:
                    break;
                case HARD:
                    break;
            }

        }

        //change key names
        playersList.put("playerX", playersList.remove("player1"));
        playersList.put("playerO", playersList.remove("player2"));

        //Print blank board
        board.printBoard();

        //Start the game
       do{
           if(turn=='O'){
               turn='X';
           }

           if(playersList.get("playerX") instanceof User){
               user.makeAMove(turn);
           }else{
               aiEasy.aiMakeAMove(turn, emptyCounter);
           }

           board.printBoard();
           board.stateOfTheGame();
           winnerX=board.isWinnerX();
           emptyCounter=board.emptyCellCounter();

           if(winnerX==true || emptyCounter==0){
               break;
           }

           if(turn=='X'){
               turn='O';
           }

           if(playersList.get("playerO") instanceof User){
               user.makeAMove(turn);
           }else{
               aiEasy.aiMakeAMove(turn, emptyCounter);
           }

           board.printBoard();
           board.stateOfTheGame();
           winnerO=board.isWinnerO();

        }while(!winnerO && !winnerX && emptyCounter!=0);

       board.printResult();

    }

}
