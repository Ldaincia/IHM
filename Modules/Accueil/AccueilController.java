package Modules.Accueil;

import GPhyStages.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import GPhyStages.Tools;

import java.io.IOException;
import java.sql.SQLException;

public class AccueilController {

    private Main main;
    @FXML private Button NosInfos;
    @FXML private Button NosStages;

    public AccueilController(Main newMain){
        main = newMain;
    }


    public void goToStage(ActionEvent e) throws IOException {
        Button NosStages = (Button) e.getSource();
        main.tools.switchScene((Stage) NosStages.getScene().getWindow(), "Stages/Stage.fxml", main.getStageController());
    }

    public void goToNosInfos(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "NosInfos/NosInfos.fxml", main.getInfosController());
    }
}
