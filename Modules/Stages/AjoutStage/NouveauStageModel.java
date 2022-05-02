package Modules.Stages.AjoutStage;

import GPhyStages.BDD;
import GPhyStages.Main;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class NouveauStageModel {


    private String nom_structureColonne;
    private String sujetColonne;
    private String lieuColonne;
    private int dureeColonne;
    private String mois_debutColonne;
    private String promotion_etuColonne;


    public NouveauStageModel (String nom_structureColonne, String sujetColonne, String lieuColonne, int dureeColonne, String mois_debutColonne, String promotion_etuColonne) {
    }

    public static void ajoutNouveauStage(String laStructure, String leSujet, String leLieu, Integer laDuree, String leDebut, String laPromo, Button ajoutStageBouton) {}

    public void setNom_structureColonne(String laStructure) {
        this.nom_structureColonne = laStructure;
    }


    public void setSujetColonne(String leSujet) {
        this.sujetColonne = leSujet;
    }


    public void setLieuColonne(String leLieu) {
        this.lieuColonne = leLieu;
    }


    public void setDureeColonne(int laDuree) {
        this.dureeColonne = laDuree;
    }


    public void setMois_debutColonne(String leDebut) {
        this.mois_debutColonne = leDebut;
    }

    public void setPromotion_etuColonne(String laPromo) {
        this.promotion_etuColonne = laPromo;
    }

    private Main main;

    public void ajoutNouveauStage(TextField laStructure, TextField leSujet, TextField leLieu, TextField laDuree, TextField leDebut, TextField laPromo)throws IOException {
            BDD.addStage(laStructure.getText(), leSujet.getText(), leLieu.getText(), Integer.parseInt(laDuree.getText()), leDebut.getText(), laPromo.getText());
            main.getStageController();
    }

}

