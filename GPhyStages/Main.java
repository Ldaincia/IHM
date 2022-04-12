package GPhyStages;

import javafx.scene.Scene;
import javafx.stage.Stage;



import Modules.Accueil.AccueilController;
import Modules.Stages.StageController;
import Modules.NosInfos.InfosController;
import Modules.Stages.AjoutStage.NouveauStageController;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.application.Platform;


public class Main extends Application {

    private AccueilController accueilController;
    private StageController stageController;
    private InfosController infosController;
    private NouveauStageController nouveauStageController;
    public Tools tools;

    @Override
    public void init() {
        accueilController = new AccueilController(this);
        stageController = new StageController(this);
        infosController = new InfosController(this);
        nouveauStageController = new NouveauStageController(this);



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


    public StageController getStageController() {
        return stageController;
    }


    public NouveauStageController getNouveauStageController() {
        return nouveauStageController;
    }


    public InfosController getInfosController() {
        return infosController;
    }




}




