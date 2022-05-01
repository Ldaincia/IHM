package Modules.Stages;


import GPhyStages.BDD;
import GPhyStages.Main;

import java.io.IOException;

import GPhyStages.NotreClasseStage;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class StageModel {

    private Main main;

    public StageModel(Main newMain){
        main = newMain;
    }

    private String nom_structureColonne;
    private String sujetColonne;
    private String lieuColonne;
    private int dureeColonne;
    private String mois_debutColonne;
    private String promotion_etuColonne;

    public StageModel(String nom_structureColonne, String sujetColonne, String lieuColonne, int dureeColonne, String mois_debutColonne, String promotion_etuColonne) {
        this.nom_structureColonne = nom_structureColonne;
        this.sujetColonne = sujetColonne;
        this.lieuColonne = lieuColonne;
        this.dureeColonne = dureeColonne;
        this.mois_debutColonne = mois_debutColonne;
        this.promotion_etuColonne = promotion_etuColonne;
    }


    public String getNom_structureColonne() {
        return nom_structureColonne;
    }

    public String getSujetColonne() {
        return sujetColonne;
    }

    public String getLieuColonne() {
        return lieuColonne;
    }

    public int getDureeColonne() {

        return dureeColonne;
    }

    public String getMois_debutColonne() {

        return mois_debutColonne;
    }

    public String getPromotion_etuColonne() {
       return promotion_etuColonne;
    }

}

