package Modules.Stages.AjoutStage;

import GPhyStages.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class NouveauStageController {

    private Main main;
    @FXML private Button home;

    public NouveauStageController(Main newMain){
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

    public void ajoutNouveauStage() throws IOException {
        String laStructure = " ";
        String leSujet = " ";
        String leLieu = " ";
        Integer laDuree = null;
        String leDebut = " ";
        String laPromo = " ";
        Button ajoutStageBouton = null;
        NouveauStageModel.ajoutNouveauStage(laStructure, leSujet, leLieu, laDuree, leDebut, laPromo, ajoutStageBouton);

    }

    public void onEnter(KeyEvent ke) throws IOException {
        if (ke.getCode().equals(KeyCode.ENTER))
        {
            this.ajoutNouveauStage();
        }
    }

    //main.tools.switchScene((Stage) ajoutStageBouton.getScene().getWindow(), "Modules/Stages/Stage.fxml", main.getStageController());



}
