/**
 * Created by Per on 03.12.2016.
 */
public class Knight extends Piece {
    public Knight(Square[][] board, int x, int y, String name, int team, Game game) {
        super(board, x, y, name, team, game);
    }

    @Override
    public boolean isMoveLegal(int newX, int newY) {
        switch(team){
            case 0:
                if(newY == y - 2 && newX == x - 1){
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y - 1 && newX == x - 2) {
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y - 2 && newX == x + 1){
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y - 1 && newX == x + 2) {
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y + 2 && newX == x - 1){
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y + 2 && newX == x + 1){
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y + 1 && newX == x - 2) {
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y + 1 && newX == x + 2) {
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfWhiteIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
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
                if(newY == y - 2 && newX == x - 1){
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y - 1 && newX == x - 2) {
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y - 2 && newX == x + 1){
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y - 1 && newX == x + 2) {
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y + 2 && newX == x - 1){
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y + 2 && newX == x + 1){
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y + 1 && newX == x - 2) {
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    }
                } else if(newY == y + 1 && newX == x + 2) {
                    if(board[newX][newY].getPiece() == null){
                        if(checkIfBlackIsInCheck(newX, newY)){
                            return false;
                        } else  {
                            return true;
                        }
                        //return true;
                    } else if(board[newX][newY].getPiece().getTeam() == 1){
                        return false;
                    } else if(board[newX][newY].getPiece().getTeam() == 0){
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

    @Override
    public void checkSquares() {
        switch(team){
            case 0:
                if(y - 2 >= 0 && x - 1 >= 0){
                    board[x - 1][y - 2].setWhiteChecksquare();
                }

                if(y - 2 >= 0 && x + 1 <= 7){
                    board[x + 1][y - 2].setWhiteChecksquare();
                }

                if(y - 1 >= 0 && x - 2 >= 0){
                    board[x - 2][y - 1].setWhiteChecksquare();
                }

                if(y - 1 >= 0 && x + 2 <= 7){
                    board[x + 2][y - 1].setWhiteChecksquare();
                }

                if(y + 2 <= 7 && x - 1 >= 0){
                    board[x - 1][y + 2].setWhiteChecksquare();
                }

                if(y + 2 <= 7 && x + 1 <= 7){
                    board[x + 1][y + 2].setWhiteChecksquare();
                }

                if(y + 1 <= 7 && x - 2 >= 0){
                    board[x - 2][y + 1].setWhiteChecksquare();
                }

                if(y + 1 <= 7 && x + 2 <= 7) {
                    board[x + 2][y + 1].setWhiteChecksquare();
                }

                break;

            case 1:
                if(y - 2 >= 0 && x - 1 >= 0){
                    board[x - 1][y - 2].setBlackchecksquare();
                }

                if(y - 2 >= 0 && x + 1 <= 7){
                    board[x + 1][y - 2].setBlackchecksquare();
                }

                if(y - 1 >= 0 && x - 2 >= 0){
                    board[x - 2][y - 1].setBlackchecksquare();
                }

                if(y - 1 >= 0 && x + 2 <= 7){
                    board[x + 2][y - 1].setBlackchecksquare();
                }

                if(y + 2 <= 7 && x - 1 >= 0){
                    board[x - 1][y + 2].setBlackchecksquare();
                }

                if(y + 2 <= 7 && x + 1 <= 7){
                    board[x + 1][y + 2].setBlackchecksquare();
                }

                if(y + 1 <= 7 && x - 2 >= 0){
                    board[x - 2][y + 1].setBlackchecksquare();
                }

                if(y + 1 <= 7 && x + 2 <= 7) {
                    board[x + 2][y + 1].setBlackchecksquare();
                }

                break;

        }
    }
}
