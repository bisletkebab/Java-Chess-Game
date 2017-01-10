import javafx.scene.image.Image;
import javafx.scene.input.Dragboard;

/**
 * Created by Per on 27.11.2016.
 */
public abstract class Piece{
    public String name;
    public int x, y;
    public Image image;
    public Square[][] board;
    public int team;
    public boolean hasMoved;
    public boolean hasEnPassant;
    public Game game;

    public Piece(Square[][] board, int x, int y, String name, int team, Game game){
        this.board = board;
        this.x = x;
        this.y = y;
        this.name = name;
        this.team = team;
        this.game = game;
        setImage();
        setPieceOnBoard();
    }

    public abstract boolean isMoveLegal(int newX, int newY);
    public abstract void checkSquares();

    private void setPieceOnBoard() {
        board[x][y].setPiece(this);
    }

    private void setImage(){
        switch(name){
            case "WHITEPAWN":
                image = new Image("file:whitepawn.png");
                break;
            case "BLACKPAWN":
                image = new Image("file:blackpawn.png");
                break;
            case "WHITEKING":
                image = new Image("file:whiteking.png");
                break;
            case "BLACKKING":
                image = new Image("file:blackking.png");
                break;
            case "WHITEBISHOP":
                image = new Image("file:whitebishop.png");
                break;
            case "BLACKBISHOP":
                image = new Image("file:blackbishop.png");
                break;
            case "WHITEKNIGHT":
                image = new Image("file:whiteknight.png");
                break;
            case "BLACKKNIGHT":
                image = new Image("file:blackknight.png");
                break;
            case "WHITEROOK":
                image = new Image("file:whiterook.png");
                break;
            case "BLACKROOK":
                image = new Image("file:blackrook.png");
                break;
            case "WHITEQUEEN":
                image = new Image("file:whitequeen.png");
                break;
            case "BLACKQUEEN":
                image = new Image("file:blackqueen.png");
                break;
        }
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getTeam() {
        return team;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setHasMoved(boolean hasMoved){
        this.hasMoved = hasMoved;
    }

    public boolean getHasMoved(){
        return hasMoved;
    }

    public void setHasEnPassant(){

    }

    public boolean checkIfWhiteIsInCheck(int newX, int newY) {
        Piece tempOpponentPiece = null;
        board[x][y].setPiece(null);
        if(board[newX][newY].getPiece() != null){
            tempOpponentPiece = board[newX][newY].getPiece();
            board[newX][newY].setPiece(null);
            board[newX][newY].setPiece(this);
        } else {
            board[newX][newY].setPiece(this);
        }

        game.checkSquares();

        if(game.whiteIsInCheck){
            if(tempOpponentPiece != null){
                board[newX][newY].setPiece(null);
                board[newX][newY].setPiece(tempOpponentPiece);
                board[x][y].setPiece(this);
            } else {
                board[newX][newY].setPiece(null);
                board[x][y].setPiece(this);
            }
            return true;
        } else {
            if(tempOpponentPiece != null){
                board[newX][newY].setPiece(null);
                board[newX][newY].setPiece(tempOpponentPiece);
                board[x][y].setPiece(this);
            } else {
                board[newX][newY].setPiece(null);
                board[x][y].setPiece(this);
            }
            return false;
        }
    }

    public boolean checkIfBlackIsInCheck(int newX, int newY) {
        Piece tempOpponentPiece = null;
        board[x][y].setPiece(null);
        if(board[newX][newY].getPiece() != null){
            tempOpponentPiece = board[newX][newY].getPiece();
            board[newX][newY].setPiece(null);
            board[newX][newY].setPiece(this);
        } else {
            board[newX][newY].setPiece(this);
        }

        game.checkSquares();

        if(game.blackIsInCheck){
            if(tempOpponentPiece != null){
                board[newX][newY].setPiece(null);
                board[newX][newY].setPiece(tempOpponentPiece);
                board[x][y].setPiece(this);
            } else {
                board[newX][newY].setPiece(null);
                board[x][y].setPiece(this);
            }
            return true;
        } else {
            if(tempOpponentPiece != null){
                board[newX][newY].setPiece(null);
                board[newX][newY].setPiece(tempOpponentPiece);
                board[x][y].setPiece(this);
            } else {
                board[newX][newY].setPiece(null);
                board[x][y].setPiece(this);
            }
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }
}
