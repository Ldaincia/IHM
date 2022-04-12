package Modules.Stages;

import GPhyStages.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class StageController {

    private Main main;
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
