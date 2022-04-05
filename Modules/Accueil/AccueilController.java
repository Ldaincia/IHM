package Modules.Accueil;

import GPhyStages.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AccueilController {

    private Main main;
    @FXML private Button home;

    public AccueilController(Main newMain){
        main = newMain;
    }


    public void butt() throws IOException, SQLException {
        main.tools.goHome(home);
    }

    public void goToStage(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "Administration/AdminOrgan.fxml", main.getAdminOrganController());
    }

    public void goToNosInfos(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        main.tools.switchScene((Stage) button.getScene().getWindow(), "Administration/AdminOrgan.fxml", main.getAdminOrganController());
    }

}
