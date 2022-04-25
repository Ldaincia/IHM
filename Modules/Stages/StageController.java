package Modules.Stages;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import GPhyStages.Main;
import GPhyStages.NotreClasseStage;

import GPhyStages.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class StageController {

    @FXML
    private TableView<Stage> tableStage;
    @FXML
    private TableColumn<Stage, String> nom_structureColonne;
    @FXML
    private TableColumn<Stage, String> sujetColonne;
    @FXML
    private TableColumn<Stage, String> lieuColonne;
    @FXML
    private TableColumn<Stage, Integer> dureeColonne;
    @FXML
    private TableColumn<Stage, String> mois_debutColonne;
    @FXML
    private TableColumn<Stage, String> promotion_etuColonne;

    @FXML
    private Label nom_structureLabel;
    @FXML
    private Label sujetLabel;
    @FXML
    private Label intituleLabel;
    @FXML
    private Label lieuLabel;
    @FXML
    private Label dureeLabel;
    @FXML
    private Label mois_debutLabel;
    @FXML
    private Label promotion_etuLabel;

    private Main main;

    public StageController(){}

    @FXML
    private void initialize(){
        nom_structureColonne.setCellValueFactory(cellData -> cellData.getValue().nom_structureProperty());
        sujetColonne.setCellValueFactory(cellData -> cellData.getValue().sujetProperty());
        lieuColonne.setCellValueFactory(cellData -> cellData.getValue().lieuProperty());
        dureeColonne.setCellValueFactory(cellData -> cellData.getValue().dureeProperty().asObject());
        mois_debutColonne.setCellValueFactory(cellData -> cellData.getValue().mois_debutProperty());
        promotion_etuColonne.setCellValueFactory(cellData -> cellData.getValue().promotion_etuProperty());
    }

    public void setMain (Main main){
        this.main = main;
        tableStage.setItems(main.getStages());
    }

    private Main ;
    @FXML private Button home;

    public StageController(Main newMain){
        main = newMain;
    }

    public void goAccueil(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "Accueil/Accueil.fxml", main.getAccueilController());
    }

    public void goToNosInfos(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "Stages/Stage.fxml", main.getStageController());
    }


    public void goToAjout(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "Stages/AjoutStage/NouveauStage.fxml", main.getNouveauStageController());
    }



}
