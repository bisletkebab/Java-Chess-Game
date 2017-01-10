/**
 * Created by Per on 01.12.2016.
 */
public class Bishop extends Piece {
    public Bishop(Square[][] board, int x, int y, String name, int team, Game game) {
        super(board, x, y, name, team, game);
    }

    @Override
    public boolean isMoveLegal(int newX, int newY) {
        switch(team){
            case 0:
                if(newX < x && newY < y){
                    //Bishop up and left
                    int yy = y;
                    for(int xx =  x - 1; xx >= newX; xx--){
                        yy--;
                        if(xx == newX & yy == newY && board[xx][yy].getPiece() != null){
                            if(board[xx][yy].getPiece().getTeam() == 1){
                                if(checkIfWhiteIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            }
                        } else if(xx == newX & yy == newY && board[xx][yy].getPiece() == null){
                            if(checkIfWhiteIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        } else if(board[xx][yy].getPiece() != null){
                            return false;
                        }
                    }
                }

                if(newX > x && newY < y){
                    //Bishop up and Right
                    int yy = y;
                    for(int xx =  x + 1; xx <= newX; xx++){
                        yy--;
                        if(xx == newX & yy == newY && board[xx][yy].getPiece() != null){
                            if(board[xx][yy].getPiece().getTeam() == 1){
                                if(checkIfWhiteIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            }
                        } else if(xx == newX & yy == newY && board[xx][yy].getPiece() == null){
                            if(checkIfWhiteIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        } else if(board[xx][yy].getPiece() != null){
                            return false;
                        }
                    }
                }

                if(newX < x && newY > y){
                    //Bishop down and left
                    int yy = y;
                    for(int xx =  x - 1; xx >= newX; xx--){
                        yy++;
                        if(yy > 7){
                            yy = 7;
                        }
                        if(xx == newX & yy == newY && board[xx][yy].getPiece() != null){
                            if(board[xx][yy].getPiece().getTeam() == 1){
                                if(checkIfWhiteIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            }
                        } else if(xx == newX & yy == newY && board[xx][yy].getPiece() == null){
                            if(checkIfWhiteIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        } else if(board[xx][yy].getPiece() != null){
                            return false;
                        }
                    }
                }

                if(newX > x && newY > y){
                    //Bishop down and right
                    int yy = y;
                    for(int xx =  x + 1; xx <= newX; xx++){

                        yy++;

                        if(xx == newX & yy == newY && board[xx][yy].getPiece() != null){
                            if(board[xx][yy].getPiece().getTeam() == 1){
                                if(checkIfWhiteIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            }
                        } else if(xx == newX & yy == newY && board[xx][yy].getPiece() == null){
                            if(checkIfWhiteIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        } else if(yy < 8 && board[xx][yy].getPiece() != null){
                            return false;
                        }
                    }
                }

                break;

            case 1:
                if(newX < x && newY < y){
                    //Bishop up and left
                    int yy = y;
                    for(int xx =  x - 1; xx >= newX; xx--){
                        yy--;
                        if(yy < 0){
                            yy = 0;
                        }
                        if(xx == newX & yy == newY && board[xx][yy].getPiece() != null){
                            if(board[xx][yy].getPiece().getTeam() == 0){
                                if(checkIfBlackIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            }
                        } else if(xx == newX & yy == newY && board[xx][yy].getPiece() == null){
                            if(checkIfBlackIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        } else if(board[xx][yy].getPiece() != null){
                            return false;
                        }
                    }
                }

                if(newX > x && newY < y){
                    //Bishop up and Right
                    int yy = y;
                    for(int xx =  x + 1; xx <= newX; xx++){
                        yy--;
                        if(yy < 0){
                            yy = 0;
                        }
                        if(xx == newX & yy == newY && board[xx][yy].getPiece() != null){
                            if(board[xx][yy].getPiece().getTeam() == 0){
                                if(checkIfBlackIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            }
                        } else if(xx == newX & yy == newY && board[xx][yy].getPiece() == null){
                            if(checkIfBlackIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        } else if(board[xx][yy].getPiece() != null){
                            return false;
                        }
                    }
                }

                if(newX < x && newY > y){
                    //Bishop down and left
                    int yy = y;
                    for(int xx =  x - 1; xx >= newX; xx--){
                        yy++;
                        if(xx == newX & yy == newY && board[xx][yy].getPiece() != null){
                            if(board[xx][yy].getPiece().getTeam() == 0){
                                if(checkIfBlackIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            }
                        } else if(xx == newX & yy == newY && board[xx][yy].getPiece() == null){
                            if(checkIfBlackIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        } else if(board[xx][yy].getPiece() != null){
                            return false;
                        }
                    }
                }

                if(newX > x && newY > y){
                    //Bishop down and right
                    int yy = y;
                    for(int xx =  x + 1; xx <= newX; xx++){
                        yy++;
                        if(xx == newX & yy == newY && board[xx][yy].getPiece() != null){
                            if(board[xx][yy].getPiece().getTeam() == 0){
                                if(checkIfBlackIsInCheck(newX, newY)){
                                    return false;
                                } else  {
                                    return true;
                                }
                                //return true;
                            }
                        } else if(xx == newX & yy == newY && board[xx][yy].getPiece() == null){
                            if(checkIfBlackIsInCheck(newX, newY)){
                                return false;
                            } else  {
                                return true;
                            }
                            //return true;
                        } else if(yy < 8 && board[xx][yy].getPiece() != null){
                            return false;
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
                //Top left diagonal check
                int topLeftyy = y;
                for(int xx =  x - 1; xx >= 0; xx--) {
                    if(topLeftyy == 0){
                        topLeftyy = 0;
                    } else {
                        topLeftyy--;
                    }
                    board[xx][topLeftyy].setWhiteChecksquare();
                    if ((xx == 0 || topLeftyy == 0) || board[xx][topLeftyy].getPiece() != null) {
                        board[xx][topLeftyy].setWhiteChecksquare();
                        break;
                    }
                }

                //Top right diagonal check
                int topRightyy = y;
                for(int xx =  x + 1; xx <= 7; xx++) {
                    if(topRightyy == 0) {
                        topRightyy = 0;
                    } else {
                        topRightyy--;
                    }
                    board[xx][topRightyy].setWhiteChecksquare();
                    if ((xx == 7 || topRightyy == 0) || board[xx][topRightyy].getPiece() != null) {
                        board[xx][topRightyy].setWhiteChecksquare();
                        break;
                    }
                }

                //Bottom left diagonal check
                int bottomLeftyy = y;
                for(int xx =  x - 1; xx >= 0; xx--) {
                    if(bottomLeftyy == 7){
                        bottomLeftyy = 7;
                    } else {
                        bottomLeftyy++;
                    }
                    board[xx][bottomLeftyy].setWhiteChecksquare();
                    if ((xx == 0 || bottomLeftyy == 0) || board[xx][bottomLeftyy].getPiece() != null) {
                        board[xx][bottomLeftyy].setWhiteChecksquare();
                        break;
                    }
                }

                //Bottom right diagonal check
                int bottomRightyy = y;
                for(int xx =  x + 1; xx <= 7; xx++) {
                    if(bottomRightyy == 7){
                        bottomRightyy = 7;
                    } else {
                        bottomRightyy++;
                    }
                    board[xx][bottomRightyy].setWhiteChecksquare();
                    if ((xx == 7 || bottomRightyy == 7) || board[xx][bottomRightyy].getPiece() != null) {
                        board[xx][bottomRightyy].setWhiteChecksquare();
                        break;
                    }
                }

                break;

            case 1:
                //Top left diagonal check
                int blackTopLeftyy = y;
                for(int xx =  x - 1; xx >= 0; xx--) {
                    if(blackTopLeftyy == 0){
                        blackTopLeftyy = 0;
                    } else {
                        blackTopLeftyy--;
                    }
                    board[xx][blackTopLeftyy].setBlackchecksquare();
                    if ((xx == 0 || blackTopLeftyy == 0) || board[xx][blackTopLeftyy].getPiece() != null) {
                        board[xx][blackTopLeftyy].setBlackchecksquare();
                        break;
                    }
                }

                //Top right diagonal check
                int blackTopRightyy = y;
                for(int xx =  x + 1; xx <= 7; xx++) {
                    if(blackTopRightyy == 0){
                        blackTopRightyy = 0;
                    } else {
                        blackTopRightyy--;
                    }
                    board[xx][blackTopRightyy].setBlackchecksquare();
                    if ((xx == 7 || blackTopRightyy == 0) || board[xx][blackTopRightyy].getPiece() != null) {
                        board[xx][blackTopRightyy].setBlackchecksquare();
                        break;
                    }
                }

                //Bottom left diagonal check
                int blackBottomLeftyy = y;
                for(int xx =  x - 1; xx >= 0; xx--) {
                    if(blackBottomLeftyy == 7){
                        blackBottomLeftyy = 7;
                    } else {
                        blackBottomLeftyy++;
                    }
                    board[xx][blackBottomLeftyy].setBlackchecksquare();
                    if ((xx == 0 || blackBottomLeftyy == 0) || board[xx][blackBottomLeftyy].getPiece() != null) {
                        board[xx][blackBottomLeftyy].setBlackchecksquare();
                        break;
                    }
                }

                //Bottom right diagonal check
                int blackBottomRightyy = y;
                for(int xx =  x + 1; xx <= 7; xx++) {
                    if(blackBottomRightyy == 7){
                        blackBottomRightyy = 7;
                    } else {
                        blackBottomRightyy++;
                    }
                    board[xx][blackBottomRightyy].setBlackchecksquare();
                    if ((xx == 7 || blackBottomRightyy == 7) || board[xx][blackBottomRightyy].getPiece() != null) {
                        board[xx][blackBottomRightyy].setBlackchecksquare();
                        break;
                    }
                }

                break;
        }
    }
}
