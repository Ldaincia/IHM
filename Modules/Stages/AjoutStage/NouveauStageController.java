package Modules.Stages.AjoutStage;

import GPhyStages.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class NouveauStageController {

    private Main main;
    @FXML private Button home;

    public NouveauStageController(Main newMain){
        main = newMain;
    }


    public void butt() throws IOException, SQLException {
        main.tools.goHome(home);
    }

    public void goHome(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), " ", main.getAccueilController());
    }

    public void goToNosInfos(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "NosInfos/NosInfos.fxml", main.getInfosController());
    }
}
