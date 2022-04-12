package Modules.NosInfos;

import GPhyStages.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class InfosController {

    private Main main;
    @FXML private Button home;

    public InfosController(Main newMain){
        main = newMain;
    }

    public void goAccueil(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "Accueil/Accueil.fxml", main.getAccueilController());
    }

    public void goToStage(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "NosInfos/NosInfos.fxml", main.getInfosController());
    }


}
