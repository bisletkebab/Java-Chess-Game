import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.*;

import java.util.Optional;

/**
 * Created by Per on 27.11.2016.
 */
public class Game{
    private Board board;
    private Piece temp;
    private Square[][] chessboard;
    private int oldx, oldy;
    private int turn, gameTurn;
    public boolean whiteIsInCheck, blackIsInCheck;
    private TextArea turnAndCoordinates;

    public Game() {
        board = new Board();
        chessboard = board.getBoard();
        temp = null;
        turn = 0;
        gameTurn = 0;
        setupBoard();
        setupTurnAndCoordinates();
    }

    private void setupBoard() {
        setupPieces();

        InnerShadow shade = new InnerShadow();
        shade.setWidth(120);
        shade.setHeight(120);
        shade.setInput(new ColorAdjust(1, 1, -0.3, 0));

        InnerShadow green = new InnerShadow();
        green.setWidth(120);
        green.setHeight(120);
        green.setInput(new ColorAdjust(1, 1, -0.3, 0));

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                int xx = x;
                int yy = y;
                chessboard[x][y].getStackPane().addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(temp == null){
                            if(chessboard[xx][yy].getPiece() != null && turn % 2 == chessboard[xx][yy].getPiece().getTeam()){
                                temp = chessboard[xx][yy].getPiece();
                                chessboard[xx][yy].getStackPane().setEffect(shade);
                                oldx =  xx;
                                oldy = yy;
                                showLegalMoves(temp);
                            }
                        } else if(temp != null){
                            if(temp.isMoveLegal(xx, yy)){
                                chessboard[xx][yy].setPiece(null);
                                temp.setXY(xx, yy);
                                temp.setHasMoved(true);
                                chessboard[xx][yy].setPiece(temp);
                                if(temp.getName() == "WHITEKING" && xx == 6 && yy == 7 || temp.getName() == "WHITEKING" && xx == 2 && yy == 7){
                                    castling(0, xx, yy);
                                } else if(temp.getName() == "BLACKKING" && xx == 6 && yy == 0 || temp.getName() == "BLACKING" && xx == 2 && yy == 0){
                                    castling(1, xx, yy);
                                }
                                if(yy == 0 && temp.getName() == "WHITEPAWN"){
                                    promotion(0, xx, yy);
                                } else if(yy == 7 && temp.getName() == "BLACKPAWN"){
                                    promotion(1, xx, yy);
                                }
                                chessboard[oldx][oldy].setPiece(null);
                                temp = null;
                                chessboard[oldx][oldy].getStackPane().setEffect(null);
                                checkSquares();
                                removeShowLegalMoves();
                                turn++;
                            } else if(chessboard[xx][yy].getPiece() != null && turn % 2 == chessboard[xx][yy].getPiece().getTeam()){
                                removeShowLegalMoves();
                                chessboard[oldx][oldy].getStackPane().setEffect(null);
                                temp = chessboard[xx][yy].getPiece();
                                chessboard[xx][yy].getStackPane().setEffect(shade);
                                oldx =  xx;
                                oldy = yy;
                                showLegalMoves(temp);
                            } else {
                                temp = null;
                                chessboard[oldx][oldy].getStackPane().setEffect(null);
                                removeShowLegalMoves();
                            }
                        }

                        if(whiteIsInCheck){
                            if(checkIfBlackWins()){
                                checkmateMessage();
                            }
                        }

                        if(blackIsInCheck){
                            if(checkIfWhiteWins()) {
                                checkmateMessage();
                            }
                        }
                    }
                });

                chessboard[x][y].getStackPane().setOnDragDetected(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(turn % 2 == chessboard[xx][yy].getPiece().getTeam()){
                            if(temp != null){
                                chessboard[temp.getX()][temp.getY()].getStackPane().setEffect(null);
                                removeShowLegalMoves();
                            }
                            Dragboard db = chessboard[xx][yy].getStackPane().startDragAndDrop(TransferMode.ANY);
                            ClipboardContent content = new ClipboardContent();
                            content.putImage(chessboard[xx][yy].getPiece().getImage());
                            db.setContent(content);
                            temp = chessboard[xx][yy].getPiece();
                            oldx = xx;
                            oldy = yy;
                            chessboard[xx][yy].getStackPane().setEffect(shade);
                            showLegalMoves(chessboard[xx][yy].getPiece());
                        }


                        event.consume();
                    }
                });

                chessboard[x][y].getStackPane().setOnDragOver(new EventHandler<DragEvent>() {
                    @Override
                    public void handle(DragEvent event) {
                        /*if(event.getGestureSource() != chessboard[xx][yy].getStackPane() && event.getDragboard().hasImage()){
                            event.acceptTransferModes(TransferMode.MOVE);
                        }*/
                        if(temp.isMoveLegal(xx, yy)){
                            event.acceptTransferModes(TransferMode.MOVE);
                        }
                        event.consume();
                    }

                });

                chessboard[x][y].getStackPane().setOnDragDropped(new EventHandler<DragEvent>() {
                    @Override
                    public void handle(DragEvent event) {
                        Dragboard db = event.getDragboard();
                        boolean success = false;
                        /*if (db.hasImage()) {
                            chessboard[xx][yy].setPiece(temp);
                            temp = null;
                            success = true;
                        }*/

                        if (chessboard[oldx][oldy].getPiece().isMoveLegal(xx, yy)) {
                            chessboard[xx][yy].setPiece(null);
                            chessboard[oldx][oldy].setPiece(null);
                            temp.setXY(xx, yy);
                            temp.setHasMoved(true);
                            chessboard[xx][yy].setPiece(temp);

                            if(temp.getName() == "WHITEKING" && xx == 6 && yy == 7 || temp.getName() == "WHITEKING" && xx == 2 && yy == 7){
                                castling(0, xx, yy);
                            } else if(temp.getName() == "BLACKKING" && xx == 6 && yy == 0 || temp.getName() == "BLACKING" && xx == 2 && yy == 0){
                                castling(1, xx, yy);
                            }

                            if(yy == 0 && temp.getName() == "WHITEPAWN"){
                                promotion(0, xx, yy);
                            } else if(yy == 7 && temp.getName() == "BLACKPAWN"){
                                promotion(1, xx, yy);
                            }

                            temp = null;
                            chessboard[oldx][oldy].getStackPane().setEffect(null);
                            checkSquares();
                            removeShowLegalMoves();
                            turn++;

                            if(whiteIsInCheck){
                                if(checkIfBlackWins()){
                                    checkmateMessage();
                                }
                            }

                            if(blackIsInCheck){
                                if(checkIfWhiteWins()) {
                                    checkmateMessage();
                                }
                            }

                            turnAndCoordinates.appendText(setTurnAndCoordinate(chessboard[xx][yy].getPiece().getName(), xx, yy));

                            success = true;
                        }

                        temp = null;
                        event.setDropCompleted(success);

                        event.consume();
                    }
                });

                chessboard[x][y].getStackPane().setOnDragDone(new EventHandler<DragEvent>() {
                    @Override
                    public void handle(DragEvent event) {
                        if(event.getTransferMode() == null){
                            if(temp != null){
                                /*temp = null;
                                removeShowLegalMoves();
                                chessboard[xx][yy].getStackPane().setEffect(null);*/
                            }
                        }
                    }
                });
            }
        }
    }

    private String setTurnAndCoordinate(String name, int x, int y){
        if(turn % 2  != 0){
            gameTurn++;
        }
        String coordinateX = "";
        String nameFirstLetter = "";
        String full;
        switch(x){
            case 0:
                coordinateX = "a";
                break;
            case 1:
                coordinateX = "b";
                break;
            case 2:
                coordinateX = "c";
                break;
            case 3:
                coordinateX = "d";
                break;
            case 4:
                coordinateX = "e";
                break;
            case 5:
                coordinateX = "f";
                break;
            case 6:
                coordinateX = "g";
                break;
            case 7:
                coordinateX = "h";
                break;
            case 8:
                coordinateX = "i";
                break;

        }

        if(name == "BLACKROOK" || name == "WHITEROOK"){
            nameFirstLetter = "R";
        } else if(name == "BLACKKNIGHT" || name == "WHITEKNIGHT"){
            nameFirstLetter = "N";
        } else if(name == "BLACKBISHOP" || name == "WHITEBISHOP"){
            nameFirstLetter = "B";
        } else if(name == "BLACKQUEEN" || name == "WHITEQUEEN"){
            nameFirstLetter = "Q";
        } else if(name == "BLACKKING" || name == "WHITEKING"){
            nameFirstLetter = "K";
        }

        if(turn % 2 != 0){
            full =  Integer.toString(gameTurn)  + ". " + nameFirstLetter + coordinateX + Integer.toString(8 - y);
        } else {
            full = "        " + nameFirstLetter + coordinateX + Integer.toString(8 - y) + "\n";
        }

        if(whiteIsInCheck || blackIsInCheck){
            full += "+";
        }

        return full;
    }

    private void setupPieces() {
        for(int i = 0; i < 8; i++) {
            new Pawn(chessboard, i, 6, "WHITEPAWN", 0, this);
            new Pawn(chessboard, i, 1, "BLACKPAWN", 1, this);
        }

        new King(chessboard, 4, 7, "WHITEKING", 0, this);
        new King(chessboard, 4, 0, "BLACKKING", 1, this);
        new Bishop(chessboard, 2, 7, "WHITEBISHOP", 0, this);
        new Bishop(chessboard, 5, 7, "WHITEBISHOP", 0, this);
        new Bishop(chessboard, 2, 0, "BLACKBISHOP", 1, this);
        new Bishop(chessboard, 5, 0, "BLACKBISHOP", 1, this);
        new Knight(chessboard, 1, 7, "WHITEKNIGHT", 0, this);
        new Knight(chessboard, 6, 7, "WHITEKNIGHT", 0, this);
        new Knight(chessboard, 1, 0, "BLACKKNIGHT", 1, this);
        new Knight(chessboard, 6, 0, "BLACKKNIGHT", 1, this);
        new Rook(chessboard, 0, 7, "WHITEROOK", 0, this);
        new Rook(chessboard, 7, 7, "WHITEROOK", 0, this);
        new Rook(chessboard, 0, 0, "BLACKROOK", 1, this);
        new Rook(chessboard, 7, 0, "BLACKROOK", 1, this);
        new Queen(chessboard, 3,7, "WHITEQUEEN", 0, this);
        new Queen(chessboard, 3, 0, "BLACKQUEEN", 1, this);
    }

    private void removeChecksquares() {
        for(int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                chessboard[x][y].removeChecksquare();
            }
        }
    }

    private void showLegalMoves(Piece temp){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(temp.isMoveLegal(x, y)){
                    chessboard[x][y].setLegalMoveOnPane();
                }
            }
        }
    }

    private void removeShowLegalMoves(){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                chessboard[x][y].removeLegalMoveOnPane();
            }
        }
    }

    public void checkSquares() {
        removeChecksquares();
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++){
                if(chessboard[x][y].getPiece() != null){
                    chessboard[x][y].getPiece().checkSquares();
                }
            }
        }
        kingsInCheck();
    }

    private boolean checkIfBlackWins(){
        boolean blackwins = true;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(chessboard[x][y].getPiece() != null && chessboard[x][y].getPiece().getTeam() == 0){
                    for(int xx = 0; xx < 8; xx++){
                        for(int yy = 0; yy < 8; yy++){
                            if(chessboard[x][y].getPiece().isMoveLegal(xx, yy)){
                                Piece temppiece = chessboard[x][y].getPiece();
                                Piece tempBlackPiece = null;
                                chessboard[x][y].setPiece(null);
                                if(chessboard[xx][yy].getPiece() != null){
                                    tempBlackPiece = chessboard[xx][yy].getPiece();
                                    chessboard[xx][yy].setPiece(null);
                                }
                                chessboard[xx][yy].setPiece(temppiece);
                                checkSquares();
                                if(!whiteIsInCheck){
                                    blackwins = false;
                                }
                                chessboard[xx][yy].setPiece(null);
                                if(tempBlackPiece != null){
                                    chessboard[xx][yy].setPiece(tempBlackPiece);
                                }
                                chessboard[x][y].setPiece(temppiece);
                                checkSquares();
                            }
                        }
                    }
                }
            }
        }

        return blackwins;
    }

    private boolean checkIfWhiteWins() {
        boolean whitewins = true;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(chessboard[x][y].getPiece() != null && chessboard[x][y].getPiece().getTeam() == 1){
                    for(int xx = 0; xx < 8; xx++){
                        for(int yy = 0; yy < 8; yy++){
                            if(chessboard[x][y].getPiece().isMoveLegal(xx, yy)){
                                Piece temppiece = chessboard[x][y].getPiece();
                                Piece tempWhitePiece = null;
                                chessboard[x][y].setPiece(null);
                                if(chessboard[xx][yy].getPiece() != null){
                                    tempWhitePiece = chessboard[xx][yy].getPiece();
                                    chessboard[xx][yy].setPiece(null);
                                }
                                chessboard[xx][yy].setPiece(temppiece);
                                checkSquares();
                                if(!blackIsInCheck){
                                    whitewins = false;
                                }
                                chessboard[xx][yy].setPiece(null);
                                if(tempWhitePiece != null){
                                    chessboard[xx][yy].setPiece(tempWhitePiece);
                                }
                                chessboard[x][y].setPiece(temppiece);
                                checkSquares();
                            }
                        }
                    }
                }
            }
        }

        return whitewins;
    }

    private void kingsInCheck() {
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++) {
                if(chessboard[x][y].getPiece() != null){
                    if(chessboard[x][y].getPiece().getName() == "WHITEKING"){
                        if(chessboard[x][y].getBlackChecksquare()){
                            //System.out.println("HVIT KONGE I SJAKK");
                            whiteIsInCheck = true;
                        } else {
                            whiteIsInCheck = false;
                        }
                    }

                    if(chessboard[x][y].getPiece().getName() == "BLACKKING") {
                        if(chessboard[x][y].getWhiteChecksquare()){
                            //System.out.println("SVART KONGE I SJAKK");
                            blackIsInCheck = true;
                        }  else {
                            blackIsInCheck =  false;
                        }
                    }
                }
            }
        }
    }

    private void promotion(int team, int x, int y){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Promotion");
        alert.setHeaderText(null);
        alert.setContentText("Choose your new piece");

        ButtonType buttonWhiteQueen = new ButtonType("Queen");
        ButtonType buttonWhiteRook = new ButtonType("Rook");
        ButtonType buttonWhiteBishop = new ButtonType("Bishop");
        ButtonType buttonWhiteKnight = new ButtonType("Knight");

        alert.getButtonTypes().setAll(buttonWhiteQueen, buttonWhiteRook, buttonWhiteBishop, buttonWhiteKnight);

        Optional<ButtonType> result = alert.showAndWait();
        switch(team){
            case 0:
                if(result.get() == buttonWhiteQueen){
                    chessboard[x][y].setPiece(null);
                    new Queen(chessboard, x, y, "WHITEQUEEN", 0, this);
                    checkSquares();
                } else if(result.get() == buttonWhiteRook){
                    new Queen(chessboard, x, y, "WHITEROOK", 0, this);
                    checkSquares();
                } else if(result.get() == buttonWhiteBishop){
                    new Queen(chessboard, x, y, "WHITEBISHOP", 0, this);
                    checkSquares();
                } else if(result.get() == buttonWhiteKnight){
                    new Queen(chessboard, x, y, "WHITEKNIGHT", 0, this);
                    checkSquares();
                }
                break;

            case 1:
                if(result.get() == buttonWhiteQueen){
                    chessboard[x][y].setPiece(null);
                    new Queen(chessboard, x, y, "BLACKQUEEN", 1, this);
                    checkSquares();
                } else if(result.get() == buttonWhiteRook){
                    new Queen(chessboard, x, y, "BLACKROOK", 1, this);
                    checkSquares();
                } else if(result.get() == buttonWhiteBishop){
                    new Queen(chessboard, x, y, "BLACKBISHOP", 1, this);
                    checkSquares();
                } else if(result.get() == buttonWhiteKnight){
                    new Queen(chessboard, x, y, "BLACKKNIGHT", 1, this);
                    checkSquares();
                }
                break;
        }

    }

    private void checkmateMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Checkmate!");

        alert.showAndWait();
    }

    public void resetBoard() {
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                chessboard[x][y].setPiece(null);
            }
        }

        turn = 0;
        setupPieces();
        checkSquares();
    }

    private void castling(int team, int x, int y){
        switch(team){
            case 0:
                if(x == 6 && y == 7){
                    chessboard[5][7].setPiece(chessboard[7][7].getPiece());
                    chessboard[5][7].getPiece().setXY(5, 7);
                    chessboard[7][7].setPiece(null);
                } else if(x == 2 && y == 7){
                    chessboard[3][7].setPiece(chessboard[0][7].getPiece());
                    chessboard[3][7].getPiece().setXY(3, 7);
                    chessboard[0][7].setPiece(null);
                }

                break;

            case 1:
                if(x == 6 && y == 0){
                    chessboard[5][0].setPiece(chessboard[7][0].getPiece());
                    chessboard[5][0].getPiece().setXY(5, 0);
                    chessboard[7][0].setPiece(null);
                } else if(x == 2 && y == 0){
                    chessboard[3][0].setPiece(chessboard[0][0].getPiece());
                    chessboard[3][0].getPiece().setXY(3, 0);
                    chessboard[0][0].setPiece(null);
                }
        }
    }

    private void setupTurnAndCoordinates(){
        turnAndCoordinates = new TextArea();
        turnAndCoordinates.setPrefColumnCount(2);
        turnAndCoordinates.setMinSize(100, 200);
        turnAndCoordinates.setMaxSize(100, 400);
        turnAndCoordinates.setEditable(false);
    }

    public TextArea getTurnAndCoordinatesTextArea(){
        return turnAndCoordinates;
    }

    public Board getBoard() {
        return board;
    }
}
