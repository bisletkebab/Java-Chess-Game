/**
 * Created by Per on 06.12.2016.
 */
public class Rook extends Piece {

    public Rook(Square[][] board, int x, int y, String name, int team, Game game) {
        super(board, x, y, name, team, game);
    }

    @Override
    public boolean isMoveLegal(int newX, int newY) {
        switch(team) {
            case 0:
                if(newX == x && newY < y){
                    for(int yy = y - 1; yy >= newY; yy--){
                        if(board[x][yy].getPiece() != null){
                           if(yy == newY && board[x][yy].getPiece().getTeam() == 1){
                               if(checkIfWhiteIsInCheck(newX, newY)){
                                   return false;
                               } else  {
                                   return true;
                               }
                               //return true;
                           } else {
                               return false;
                           }
                        } else if(yy == newY && board[x][yy].getPiece() == null){
                            if(checkIfWhiteIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        }
                    }
                } else if(newX == x && newY > y) {
                    for(int yy = y + 1; yy <= newY; yy++){
                        if(board[x][yy].getPiece() != null){
                            if(yy == newY && board[x][yy].getPiece().getTeam() == 1){
                                if(checkIfWhiteIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            } else {
                                return false;
                            }
                        } else if(yy == newY && board[x][yy].getPiece() == null){
                            if(checkIfWhiteIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        }
                    }
                } else if(newY == y && newX < x) {
                    for(int xx = x - 1; xx >= newX; xx--) {
                        if(board[xx][y].getPiece() != null){
                            if(xx == newX && board[xx][y].getPiece().getTeam() == 1){
                                if(checkIfWhiteIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            } else {
                                return false;
                            }
                        } else if(xx == newX && board[xx][y].getPiece() == null){
                            if(checkIfWhiteIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        }
                    }
                } else if(newY == y && newX > x) {
                    for(int xx = x + 1; xx <= newX; xx++) {
                        if(board[xx][y].getPiece() != null){
                            if(xx == newX && board[xx][y].getPiece().getTeam() == 1){
                                if(checkIfWhiteIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            } else {
                                return false;
                            }
                        } else if(xx == newX && board[xx][y].getPiece() == null){
                            if(checkIfWhiteIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        }
                    }
                }

                break;

            case 1:
                if(newX == x && newY < y){
                    for(int yy = y - 1; yy >= newY; yy--){
                        if(board[x][yy].getPiece() != null){
                            if(yy == newY && board[x][yy].getPiece().getTeam() == 0){
                                if(checkIfBlackIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            } else {
                                return false;
                            }
                        } else if(yy == newY && board[x][yy].getPiece() == null){
                            if(checkIfBlackIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        }
                    }
                } else if(newX == x && newY > y) {
                    for(int yy = y + 1; yy <= newY; yy++){
                        if(board[x][yy].getPiece() != null){
                            if(yy == newY && board[x][yy].getPiece().getTeam() == 0){
                                if(checkIfBlackIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            } else {
                                return false;
                            }
                        } else if(yy == newY && board[x][yy].getPiece() == null){
                            if(checkIfBlackIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        }
                    }
                } else if(newY == y && newX < x) {
                    for(int xx = x - 1; xx >= newX; xx--) {
                        if(board[xx][y].getPiece() != null){
                            if(xx == newX && board[xx][y].getPiece().getTeam() == 0){
                                if(checkIfBlackIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            } else {
                                return false;
                            }
                        } else if(xx == newX && board[xx][y].getPiece() == null){
                            if(checkIfBlackIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        }
                    }
                } else if(newY == y && newX > x) {
                    for(int xx = x + 1; xx <= newX; xx++) {
                        if(board[xx][y].getPiece() != null){
                            if(xx == newX && board[xx][y].getPiece().getTeam() == 0){
                                if(checkIfBlackIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            } else {
                                return false;
                            }
                        } else if(xx == newX && board[xx][y].getPiece() == null){
                            if(checkIfBlackIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        }
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
                //Rook upwards check
                for(int topY = y - 1; topY >= 0; topY--){
                    board[x][topY].setWhiteChecksquare();
                    if(board[x][topY].getPiece() != null) {
                        break;
                    }
                }

                //Rook downards check
                for(int bottomY = y + 1; bottomY <= 7; bottomY++) {
                    board[x][bottomY].setWhiteChecksquare();
                    if(board[x][bottomY].getPiece() != null) {
                        break;
                    }
                }

                //Rook left check
                for(int leftX = x - 1; leftX >= 0; leftX--){
                    board[leftX][y].setWhiteChecksquare();
                    if(board[leftX][y].getPiece() != null) {
                        break;
                    }
                }

                for(int rightX = x + 1; rightX <= 7; rightX++){
                    board[rightX][y].setWhiteChecksquare();
                    if(board[rightX][y].getPiece() != null) {
                        break;
                    }
                }
                break;

            case 1:

                //Rook upwards check
                for(int topY = y - 1; topY >= 0; topY--){
                    board[x][topY].setBlackchecksquare();
                    if(board[x][topY].getPiece() != null) {
                        break;
                    }
                }

                //Rook downards check
                for(int bottomY = y + 1; bottomY <= 7; bottomY++) {
                    board[x][bottomY].setBlackchecksquare();
                    if(board[x][bottomY].getPiece() != null) {
                        break;
                    }
                }

                //Rook left check
                for(int leftX = x - 1; leftX >= 0; leftX--){
                    board[leftX][y].setBlackchecksquare();
                    if(board[leftX][y].getPiece() != null) {
                        break;
                    }
                }

                for(int rightX = x + 1; rightX <= 7; rightX++){
                    board[rightX][y].setBlackchecksquare();
                    if(board[rightX][y].getPiece() != null) {
                        break;
                    }
                }
                break;
        }
    }
}
