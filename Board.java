package ticTacToeWithAI;

public class Board {

    char [][] boardMatrix;
    public boolean winnerX;
    public boolean winnerO;
    static int emptyCounter;

    public Board(char [][] boardMatrix, boolean winnerX, boolean winnerO){
        this.boardMatrix=boardMatrix;
        setInitialBoard();
        this.winnerX=winnerX;
        this.winnerO=winnerO;
    }

    public boolean isWinnerO() {
        return winnerO;
    }

    public boolean isWinnerX(){
        return winnerX;
    }

    //Sets initial state of the grid
    char[][] setInitialBoard(){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boardMatrix[i][j]=' ';
            }
        }

        return boardMatrix;
    }

    //Prints matrix as a grid
    void printBoard(){

        System.out.println("---------");
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(boardMatrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");

    }


    //State of the game
    void stateOfTheGame(){

        int storeResult=0;

        for (int i =0;i<8;i++){
            switch (i){
                case 0:
                    storeResult=boardMatrix[0][0]+boardMatrix[0][1]+boardMatrix[0][2];
                    break;
                case 1:
                    storeResult=boardMatrix[1][0]+boardMatrix[1][1]+boardMatrix[1][2];
                    break;
                case 2:
                    storeResult=boardMatrix[2][0]+boardMatrix[2][1]+boardMatrix[2][2];
                    break;
                case 3:
                    storeResult=boardMatrix[0][0]+boardMatrix[1][0]+boardMatrix[2][0];
                    break;
                case 4:
                    storeResult=boardMatrix[0][1]+boardMatrix[1][1]+boardMatrix[2][1];
                    break;
                case 5:
                    storeResult=boardMatrix[0][2]+boardMatrix[1][2]+boardMatrix[2][2];
                    break;
                case 6:
                    storeResult=boardMatrix[0][0]+boardMatrix[1][1]+boardMatrix[2][2];
                    break;
                case 7:
                    storeResult=boardMatrix[0][2]+boardMatrix[1][1]+boardMatrix[2][0];
                    break;
            }

            if(storeResult==237) {
                winnerO=true;
            } else if(storeResult==264){
                winnerX=true;
            }
        }

    }

    //Print result
    void printResult(){

        if (winnerO){
            System.out.println("O wins");
        }else if(winnerX){
            System.out.println("X wins");
        }else{
            System.out.println("Draw");
        }
    }

    //Check empty cells
    int emptyCellCounter(){

        this.emptyCounter =0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(boardMatrix[i][j]==' '){
                    this.emptyCounter++;
                }

            }
        }

        return emptyCounter;

    }

}
