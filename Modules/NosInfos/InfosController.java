package Modules.NosInfos;

import GPhyStages.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InfosController {

    private Main main;
    @FXML private Button home;

    public InfosController(Main newMain){
        main = newMain;
    }

//
//    public void goHome() throws IOException, SQLException {
//        main.tools.goHome(home);
//    }
//
//    public void goToStage(ActionEvent e) throws IOException {
//        Button button = (Button) e.getSource();
//        main.tools.switchScene((Stage) button.getScene().getWindow(), "NosInfos/NosInfos.fxml", main.getAdminOrganController());
//    }
//
//    public void goToNosInfos(ActionEvent e) throws IOException {
//        Button button = (Button) e.getSource();
//        main.tools.switchScene((Stage) button.getScene().getWindow(), "NosInfos/NosInfos.fxml", main.getAdminOrganController());
//    }

}
