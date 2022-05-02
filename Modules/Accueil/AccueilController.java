package Modules.Accueil;

import GPhyStages.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import GPhyStages.Tools;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class AccueilController {

    private Main main;

    @FXML
    private Button NosInfos;

    @FXML
    private Button NosStages;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public AccueilController(Main newMain){
        main = newMain;
    }


    public void goToStage(ActionEvent e) throws IOException {
        Button NosStages = (Button) e.getSource();
        root = FXMLLoader.load(getClass().getResource("Stages/Stage.fxml"));
        stage = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        //main.tools.switchScene((Stage) NosStages.getScene().getWindow(), "Stages/Stage.fxml", main.getStageController());
    }

    public void goToNosInfos(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "NosInfos/NosInfos.fxml", main.getInfosController());
    }
}
