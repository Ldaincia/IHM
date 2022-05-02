package Modules.Stages;

import GPhyStages.BDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import GPhyStages.Main;
import GPhyStages.NotreClasseStage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import GPhyStages.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static GPhyStages.BDD.connect;
import static GPhyStages.BDD.getLocation;


public class StageController implements Initializable {

    @FXML
    private TableView<NotreClasseStage> tableStage;
    @FXML
    private TableColumn<NotreClasseStage,String> nom_structureColonne;
    @FXML
    private TableColumn<NotreClasseStage,String> sujetColonne;

    public ObservableList<StageModel> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<NotreClasseStage,String> lieuColonne;
    @FXML
    private TableColumn<NotreClasseStage,Integer> dureeColonne;
    @FXML
    private TableColumn<NotreClasseStage,String> mois_debutColonne;
    @FXML
    private TableColumn<NotreClasseStage,String> promotion_etuColonne;

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

    public void loadList (){
        for (NotreClasseStage item : BDD.selectionBDD()){
            tableStage.getItems().add(item);
        }
        initialize();
    }

    @FXML
    private void initialize() {
        nom_structureColonne.setCellValueFactory(new PropertyValueFactory<NotreClasseStage, String>("nom_structure"));
        sujetColonne.setCellValueFactory(new PropertyValueFactory<NotreClasseStage, String>("sujet"));
        lieuColonne.setCellValueFactory(new PropertyValueFactory<NotreClasseStage, String>("lieu"));
        dureeColonne.setCellValueFactory(new PropertyValueFactory<NotreClasseStage, Integer>("duree"));
        mois_debutColonne.setCellValueFactory(new PropertyValueFactory<NotreClasseStage, String>("mois_debut"));
        promotion_etuColonne.setCellValueFactory(new PropertyValueFactory<NotreClasseStage, String>("promotion_etu"));
    }

    public void setMain(Main main) {
        this.main = main;
        tableStage.setItems(main.getNotreClasseStage());
    }

    @FXML
    private Button home;


    public StageController(Main newMain) {
        main = newMain;
    }

    public void goAccueil(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "Accueil/Accueil.fxml", main.getAccueilController());
    }

    public void goToNosInfos(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "../Modules/NosInfos/NosInfos.fxml", main.getInfosController());
    }

    public void goToAjout(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "Stages/AjoutStage/NouveauStage.fxml", main.getNouveauStageController());
    }

    public void deleteStage() {
        NotreClasseStage leStage = tableStage.getSelectionModel().getSelectedItem();
        BDD.deleteStage(leStage.getId());
        tableStage.getItems().remove(leStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
