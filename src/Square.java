import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * Created by Per on 27.11.2016.
 */
public class Square {
    private Piece piece;
    private boolean isWhite;
    private StackPane stackPane;
    private ImageView imagepiece;
    private boolean whitechecksquare;
    private boolean blackchecksquare;
    private Image legalMoveImage;
    private ImageView legalMoveImageView;

    public Square(boolean isWhite, Piece piece){
        this.isWhite = isWhite;
        this.piece = piece;
        stackPane = new StackPane();
        stackPane.setMinSize(60, 60);
        setColorOnPane();
        setupLegalMoveImage();
    }

    public void setWhiteChecksquare() {
        whitechecksquare = true;
    }

    public void setBlackchecksquare() {
        blackchecksquare = true;
    }

    public void removeChecksquare() {
        whitechecksquare = false;
        blackchecksquare = false;
    }

    public boolean getWhiteChecksquare() {
        return whitechecksquare;
    }

    public boolean getBlackChecksquare() {
        return blackchecksquare;
    }

    private void setColorOnPane(){
        String color ;
        if (isWhite) {
            color = "white";
        } else {
            color = "black";
        }
        stackPane.setStyle("-fx-background-color: "+color+";");
    }

    public void setPiece(Piece piece){
        this.piece = piece;
        if(piece != null){
            imagepiece = new ImageView(piece.getImage());
            setPieceOnPane();
        } else if(piece == null){
            setPieceOnPane();
        }
    }

    private void setPieceOnPane(){
        if(piece != null){
            stackPane.getChildren().add(imagepiece);
        } else {
            stackPane.getChildren().remove(imagepiece);
        }

    }

    private void setupLegalMoveImage(){
        legalMoveImage = new Image("file:legalmove.png");
        legalMoveImageView = new ImageView(legalMoveImage);
        legalMoveImageView.setFitHeight(20);
        legalMoveImageView.setFitWidth(20);
    }

    public void setLegalMoveOnPane(){
        stackPane.getChildren().add(legalMoveImageView);
    }

    public void removeLegalMoveOnPane(){
        stackPane.getChildren().remove(legalMoveImageView);
    }

    public Piece getPiece() {
        return piece;
    }

    public StackPane getStackPane() {
        return stackPane;
    }
}
