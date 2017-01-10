/**
 * Created by Per on 30.11.2016.
 */
public class King extends Piece {

    public King(Square[][] board, int x, int y, String name, int team, Game game) {
        super(board, x, y, name, team, game);
    }

    @Override
    public boolean isMoveLegal(int newX, int newY) {
        switch(team){
            case 0:
                //Only move king one step
                if(newX == x + 1 || newX == x - 1 || newX == x){
                    if(newY == y + 1 || newY == y - 1 || newY == y){
                        //Check if new square puts king in check
                         if(board[newX][newY].getBlackChecksquare()){
                            return false;
                        }
                        //Check if the new square is available
                        if(board[newX][newY].getPiece() == null){
                            return true;
                        }
                        //If the square is not available, check if it can be taken
                        else if(board[newX][newY].getPiece().getTeam() == 1){
                            return true;
                        }
                    }
                }

                //Castling short
                if(newX == 6 && newY == 7 && !hasMoved){
                    if((board[5][7].getPiece() == null & !board[5][7].getBlackChecksquare()) && (board[6][7].getPiece() == null & !board[6][7].getBlackChecksquare()) && !board[7][7].getPiece().getHasMoved()){
                        return true;
                    }
                }

                //Castling long
                if(newX == 2 && newY == 7 && !hasMoved){
                    if((board[1][7].getPiece() == null & !board[1][7].getBlackChecksquare()) && (board[2][7].getPiece() == null & !board[2][7].getBlackChecksquare()) && (board[3][7].getPiece() == null & !board[3][7].getBlackChecksquare()) &&!board[0][7].getPiece().getHasMoved()){
                        return true;
                    }
                }
                break;

            case 1:
                //Only move king one step
                if(newX == x + 1 || newX == x - 1 || newX == x){
                    if(newY == y + 1 || newY == y - 1 || newY == y){
                        if(board[newX][newY].getWhiteChecksquare()){
                            return false;
                        }
                        //Check if new square puts king in check
                        if(board[newX][newY].getPiece() == null){
                            return true;
                        }
                        //If the square is not available, check if it can be taken
                        else if(board[newX][newY].getPiece().getTeam() == 0){
                            return true;
                        }
                    }
                }

                //Castling short
                if(newX == 6 && newY == 0 && !hasMoved){
                    if((board[5][0].getPiece() == null & !board[5][0].getWhiteChecksquare()) && (board[6][0].getPiece() == null & !board[6][0].getWhiteChecksquare()) && !board[7][0].getPiece().getHasMoved()){
                        return true;
                    }
                }

                //Castling long
                if(newX == 2 && newY == 0 && !hasMoved){
                    if((board[1][0].getPiece() == null & !board[1][0].getWhiteChecksquare()) && (board[2][0].getPiece() == null & !board[2][0].getWhiteChecksquare()) && (board[3][0].getPiece() == null & !board[3][0].getWhiteChecksquare()) && !board[0][0].getPiece().getHasMoved()){
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void checkSquares() {
        switch(team){
            case 0:
                if(x == 0 && y == 7){
                    //Kings right square
                    board[x + 1][y].setWhiteChecksquare();
                    //Kings lower square
                    board[x][y - 1].setWhiteChecksquare();
                    //Kings lower right square
                    board[x + 1][y - 1].setWhiteChecksquare();
                } else if(x == 7 && y == 7) {
                    //Kings left square
                    board[x - 1][y].setWhiteChecksquare();
                    //Kings lower square
                    board[x][y - 1].setWhiteChecksquare();
                    //Kings lower left square
                    board[x - 1][y - 1].setWhiteChecksquare();
                } else if(x == 0 && y == 0){
                    //Kings right square
                    board[x + 1][y].setWhiteChecksquare();
                    //Kings top square
                    board[x][y + 1].setWhiteChecksquare();
                    //Kings top right square
                    board[x + 1][y + 1].setWhiteChecksquare();
                } else if(x == 7 && y == 0){
                    //Kings left square
                    board[x - 1][y].setWhiteChecksquare();
                    //Kings top square
                    board[x][y + 1].setWhiteChecksquare();
                    //Kings top left square
                    board[x - 1][y + 1].setWhiteChecksquare();
                } else if(x == 0){
                    board[x][y - 1].setWhiteChecksquare();
                    board[x][y + 1].setWhiteChecksquare();
                    board[x + 1][y - 1].setWhiteChecksquare();
                    board[x + 1][y].setWhiteChecksquare();
                    board[x + 1][y + 1].setWhiteChecksquare();
                } else if(x == 7){
                    board[x][y - 1].setWhiteChecksquare();
                    board[x][y + 1].setWhiteChecksquare();
                    board[x - 1][y - 1].setWhiteChecksquare();
                    board[x - 1][y].setWhiteChecksquare();
                    board[x - 1][y + 1].setWhiteChecksquare();
                } else if(y == 0){
                    board[x - 1][y].setWhiteChecksquare();
                    board[x + 1][y].setWhiteChecksquare();
                    board[x - 1][y + 1].setWhiteChecksquare();
                    board[x][y + 1].setWhiteChecksquare();
                    board[x + 1][y + 1].setWhiteChecksquare();
                } else if(y == 7) {
                    board[x - 1][y].setWhiteChecksquare();
                    board[x + 1][y].setWhiteChecksquare();
                    board[x - 1][y - 1].setWhiteChecksquare();
                    board[x][y - 1].setWhiteChecksquare();
                    board[x + 1][y - 1].setWhiteChecksquare();
                } else {
                    //Kings 3 upper squares
                    board[x - 1][y - 1].setWhiteChecksquare();
                    board[x][y - 1].setWhiteChecksquare();
                    board[x + 1][y - 1].setWhiteChecksquare();
                    //Kings left and right square
                    board[x - 1][y].setWhiteChecksquare();
                    board[x + 1][y].setWhiteChecksquare();
                    //King 3 bottom squares
                    board[x - 1][y + 1].setWhiteChecksquare();
                    board[x][y + 1].setWhiteChecksquare();
                    board[x + 1][y + 1].setWhiteChecksquare();
                }
                break;

            case 1:
                if(x == 0 && y == 7){
                    //Kings right square
                    board[x + 1][y].setBlackchecksquare();
                    //Kings lower square
                    board[x][y - 1].setBlackchecksquare();
                    //Kings lower right square
                    board[x + 1][y - 1].setBlackchecksquare();
                } else if(x == 7 && y == 7) {
                    //Kings left square
                    board[x - 1][y].setBlackchecksquare();
                    //Kings lower square
                    board[x][y - 1].setBlackchecksquare();
                    //Kings lower left square
                    board[x - 1][y - 1].setBlackchecksquare();
                } else if(x == 0 && y == 0){
                    //Kings right square
                    board[x + 1][y].setBlackchecksquare();
                    //Kings top square
                    board[x][y + 1].setBlackchecksquare();
                    //Kings top right square
                    board[x + 1][y + 1].setBlackchecksquare();
                } else if(x == 7 && y == 0){
                    //Kings left square
                    board[x - 1][y].getBlackChecksquare();
                    //Kings top square
                    board[x][y + 1].setBlackchecksquare();
                    //Kings top left square
                    board[x - 1][y + 1].setBlackchecksquare();
                } else if(x == 0){
                    board[x][y - 1].setBlackchecksquare();
                    board[x][y + 1].setBlackchecksquare();
                    board[x + 1][y - 1].setBlackchecksquare();
                    board[x + 1][y].setBlackchecksquare();
                    board[x + 1][y + 1].setBlackchecksquare();
                } else if(x == 7){
                    board[x][y - 1].setBlackchecksquare();
                    board[x][y + 1].setBlackchecksquare();
                    board[x - 1][y - 1].setBlackchecksquare();
                    board[x - 1][y].setBlackchecksquare();
                    board[x - 1][y + 1].setBlackchecksquare();
                } else if(y == 0){
                    board[x - 1][y].setBlackchecksquare();
                    board[x + 1][y].setBlackchecksquare();
                    board[x - 1][y + 1].setBlackchecksquare();
                    board[x][y + 1].setBlackchecksquare();
                    board[x + 1][y + 1].setBlackchecksquare();
                } else if(y == 7) {
                    board[x - 1][y].setBlackchecksquare();
                    board[x + 1][y].setBlackchecksquare();
                    board[x - 1][y - 1].setBlackchecksquare();
                    board[x][y - 1].setBlackchecksquare();
                    board[x + 1][y - 1].setBlackchecksquare();
                } else {
                    //Kings 3 upper squares
                    board[x - 1][y - 1].setBlackchecksquare();
                    board[x][y - 1].setBlackchecksquare();
                    board[x + 1][y - 1].setBlackchecksquare();
                    //Kings left and right square
                    board[x - 1][y].setBlackchecksquare();
                    board[x + 1][y].setBlackchecksquare();
                    //King 3 bottom squares
                    board[x - 1][y + 1].setBlackchecksquare();
                    board[x][y + 1].setBlackchecksquare();
                    board[x + 1][y + 1].setBlackchecksquare();
                }
                break;
        }
    }
}
