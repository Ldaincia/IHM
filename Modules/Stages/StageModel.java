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

    private String nomStructure;
    private String sujetStage;
    private int duree;
    private String debutStage;
    private int promo;

    public StageModel(String nom_structureColonne, String sujetColonne, String lieuColonne, int dureeColonne, String mois_debutColonne, String promotion_etuColonne) {
    }

    public String getnom_structureColonne() {
        return nomStructure;
    }


    public void setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
    }

    public String getSujetStage() {
        return sujetStage;
    }

    public void setSujetStage(String sujetStage) {
        this.sujetStage = sujetStage;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDebutStage() {
        return debutStage;
    }

    public void setDebutStage(String debutStage) {
        this.debutStage = debutStage;
    }

    public String getPromo() {
        if (promo == 1) {
            return "L3";
        }
        else if (promo == 2) {
            return "M1";
        }
        else {
            return "M2";
        }
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    @Override
    public String toString() {
        return nomStructure;
    }

}

