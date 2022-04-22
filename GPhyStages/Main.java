package GPhyStages;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.Scene;

public class Main extends Application {
    public static void main (String []args) {
        launch(args);
    }
    @Override

    public void start (Stage primaryStage) {
        primaryStage.setTitle(" TITRE FENETRE ");
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setScene(new Scene(new Label(" HELLO WORLD "), 1280, 720));
        primaryStage.show();
    }

}
