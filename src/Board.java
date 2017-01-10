

/**
 * Created by Per on 27.11.2016.
 */
public class Board {
    private Square[][] board;

    public Board(){
        board = new Square[8][8];
        createBoard();
    }

    private void createBoard(){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                boolean isWhite = false;
                if((x + y) % 2 == 0){
                    isWhite = true;
                }
                board[x][y] = new Square(isWhite, null);

            }
        }
    }

    public Square[][] getBoard() {
        return board;
    }
}
