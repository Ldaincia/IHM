package Modules.Stages;

import GPhyStages.BDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import GPhyStages.Main;
import GPhyStages.NotreClasseStage;

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
import java.util.ResourceBundle;


public class StageController implements Initializable {

    @FXML
    private TableView<NotreClasseStage> tableStage;
    @FXML
    private String nom_structureColonne;
    @FXML
    private String sujetColonne;

    public ObservableList<StageModel> data = FXCollections.observableArrayList();
    @FXML
    private String lieuColonne;
    @FXML
    private int dureeColonne;
    @FXML
    private String mois_debutColonne;
    @FXML
    private String promotion_etuColonne;

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

    public StageController(String nom_structureColonne, String sujetColonne, String lieuColonne, int dureeColonne, String mois_debutColonne, String promotion_etuColonne) {

        this.nom_structureColonne = nom_structureColonne;
        this.sujetColonne = sujetColonne;
        this.lieuColonne = lieuColonne;
        this.dureeColonne = dureeColonne;
        this.mois_debutColonne = mois_debutColonne;
        this.promotion_etuColonne = promotion_etuColonne;

    };

     @FXML
    public void viewStage(){
        try (Connection connection = BDD.connect(BDD.getLocation())){
            String sql = "SELECT * FROM mesStages";
            PreparedStatement stat = connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            data.clear();
            while(rs.next()) {
                data.add(new StageModel(rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
            }
            connection.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

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
        tableStage.setItems(main.getNotreClasseStage());
    }

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


    public void deleteStage(NotreClasseStage leStage, TableView laColonne) {
        BDD.deleteStage(leStage.getId());
        laColonne.getItems().remove(leStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
