import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Per on 27.11.2016.
 */
public class App extends Application{
    private Game game;

    public static void main(String[] args) {
        launch(args);
    }

    public App() {
        game = new Game();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        BorderPane borderPane = new BorderPane();

        setupTurnAndCoordinates(borderPane);
        setupCoordinates(root);
        setupMenu(borderPane);

        borderPane.setCenter(root);

        final int size = 8 ;
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                root.add(game.getBoard().getBoard()[x][y].getStackPane(), x, y);
            }
        }


        /*for (int i = 0; i < size; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            root.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }*/

        Scene scene = new Scene(borderPane, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    private void setupTurnAndCoordinates(BorderPane borderPane) {
        borderPane.setRight(game.getTurnAndCoordinatesTextArea());
    }

    private void setupCoordinates(GridPane root){
        for(int y = 1; y < 9; y++){
                StackPane stackPaneCoordinateY = new StackPane();
                stackPaneCoordinateY.setMaxSize(60, 60);
                Label labelCoordinateY = new Label(Integer.toString(y));
                labelCoordinateY.setAlignment(Pos.CENTER);
                stackPaneCoordinateY.getChildren().add(labelCoordinateY);
                root.add(stackPaneCoordinateY, 8, 8 - y);
        }

        int xCoordinate = 0;
        for(char x = 'A'; x < 'I'; x++){
            StackPane stackPaneCoordinateY = new StackPane();
            stackPaneCoordinateY.setMaxSize(60, 60);
            Label labelCoordinateY = new Label(Character.toString(x));
            labelCoordinateY.setAlignment(Pos.CENTER);
            stackPaneCoordinateY.getChildren().add(labelCoordinateY);
            root.add(stackPaneCoordinateY, xCoordinate, 8);
            xCoordinate++;
        }
    }

    private void setupMenu(BorderPane borderPane){
        VBox topContainer = new VBox();
        MenuBar mainMenu = new MenuBar();

        topContainer.getChildren().add(mainMenu);

        borderPane.setTop(topContainer);

        Menu file = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.resetBoard();
            }
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        file.getItems().addAll(newGame, exit);

        Menu settings = new Menu("Settings");
        MenuItem setTime = new MenuItem("Time");
        setTime.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Time");
            }
        });

        settings.getItems().addAll(setTime);

        Menu about = new Menu("About");
        MenuItem help = new MenuItem("Help");
        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Help");
            }
        });

        MenuItem created = new MenuItem("Created by");
        created.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Created");
            }
        });

        about.getItems().addAll(help, created);

        mainMenu.getMenus().addAll(file, settings, about);
    }
}
