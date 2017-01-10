/**
 * Created by Per on 27.11.2016.
 */
public class Pawn extends Piece{

    public Pawn(Square[][] board, int x, int y, String name, int team, Game game) {
        super(board, x, y, name, team, game);
    }

    @Override
    public void checkSquares(){
        switch(team){
            case 0:
                if(y != 0){
                    if(x == 0){
                        board[x + 1][y - 1].setWhiteChecksquare();
                    } else if(x == 7){
                        board[x - 1][y - 1].setWhiteChecksquare();
                    } else {
                        board[x - 1][y - 1].setWhiteChecksquare();
                        board[x + 1][y - 1].setWhiteChecksquare();
                    }
                }
                break;
            case 1:
                if(y != 7){
                    if(x == 0){
                        board[x + 1][y + 1].setBlackchecksquare();
                    } else if(x == 7){
                        board[x - 1][y + 1].setBlackchecksquare();
                    } else {
                        board[x - 1][y + 1].setBlackchecksquare();
                        board[x + 1][y + 1].setBlackchecksquare();
                    }
                }
                break;
        }
    }

    @Override
    public boolean isMoveLegal(int newX, int newY) {
        switch(team){
            case 0:
                //Check if there is a piece that can be captured
                if(newX == (x + 1) && newY == (y - 1) && board[newX][newY].getPiece() != null){
                    if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                }

                if(newX == (x - 1) && newY == (y - 1) && board[newX][newY].getPiece() != null){
                    if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                }

                //Stop white pawns from moving over other pieces
                for(int yy = y - 1; yy >= newY; yy--){
                    if(board[newX][yy].getPiece() != null){
                        return false;
                    }
                }

                //Check if pawn has been moved before, if not, allows it to move to spaces up
                if(!hasMoved){
                    if(newX == x && (newY < y && newY >= y - 2)){
                        //hasMoved = true;
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else {
                    if(newX == x && (newY < y && newY >= y - 1)){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                }

                break;
            case 1:
                //Check if there is a piece that can be captured
                if(newX == (x + 1) && newY == (y + 1) && board[newX][newY].getPiece() != null){
                    if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                }

                if(newX == (x - 1) && newY == (y + 1) && board[newX][newY].getPiece() != null){
                    if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                }

                //Stop black pawns from moving over other pieces
                for(int yy = y + 1; yy <= newY; yy++){
                    if(board[newX][yy].getPiece() != null){
                        return false;
                    }
                }

                //Check if pawn has been moved before, if not, allows it to move to spaces up
                if(!hasMoved){
                    if(newX == x && (newY > y && newY <= y + 2)){
                        //hasMoved = true;
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else {
                    if(newX == x && (newY > y && newY <= y + 1)){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                }
                break;
        }

        return false;
    }
}
