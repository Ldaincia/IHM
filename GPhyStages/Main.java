package GPhyStages;

import Modules.Accueil.AccueilController;
import Modules.Stages.StageController;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.Scene;

public class Main extends Application {

    private AccueilController accueilController;
    private StageController stageController;
    private InfosController infosController;
    public Tools tools;

    @Override
    public void init() {
        AccueilController = new AccueilController(this);
        StageController = new StageController(this);

    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(" TITRE FENETRE ");
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setScene(new Scene(new Label(" HELLO WORLD "), 1280, 720));
        primaryStage.show();
    }

    public AccueilController getAccueilController() {
        return accueilController;
    }

}




