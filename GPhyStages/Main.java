package GPhyStages;

import Modules.NosInfos.InfosController;
import Modules.Stages.StageController;
import Modules.Stages.AjoutStage.NouveauStageController;
import Modules.Accueil.AccueilController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;


import java.io.IOException;

public class Main extends Application {

    private static final ObservableList<GPhyStages.NotreClasseStage> stages = FXCollections.observableArrayList();
    public Tools tools;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private StageController stageController;
    private NouveauStageController nouveauStageController;
    private AccueilController accueilController;
    private InfosController infosController;

    @Override
    public void start (Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(" TITRE FENETRE ");

        initRootLayout();

        showStageOverview();
        /*
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setScene(new Scene(new Label(" HELLO WORLD "), 1280, 720));
        primaryStage.show();
        */
    }

    public void init() {
        stageController = new StageController(this);
        nouveauStageController = new NouveauStageController(this);
        accueilController = new AccueilController(this);
        infosController = new InfosController(this);
    }


    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Acceuil.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



   public void showStageOverview(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Modules/Stages/Stage.fxml"));
            AnchorPane stageOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(stageOverview);

            StageController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e){
            e.printStackTrace();
        }
   }

// NOS GETTERS
    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public AccueilController getAccueilController() {
        return accueilController;
    }

    public InfosController getInfosController() {
        return infosController;
    }

    public StageController getStageController () {
        return stageController;
    }

    public NouveauStageController getNouveauStageController() {
        return nouveauStageController;
    }

    // FIN DE NOS GETTERS


    public Main(){
        BDD.selectionBDD(stages);
    }


    // POUR POUVOIR ECRIRE DANS NOTRE CLASSE NOTRECLASSESTAGE
    private ObservableList<NotreClasseStage> notreClasseStage() { return notreClasseStage();
    };
    public ObservableList<NotreClasseStage> getNotreClasseStage (){return notreClasseStage();}
    //


    public static void main (String [] args) {
        launch(args);
    }

}