package Modules.Stages;


import GPhyStages.BDD;
import GPhyStages.Main;

import java.io.IOException;

import GPhyStages.NotreClasseStage;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class StageModel (String nom_structureColonne, String sujetColonne, String lieuColonne, int dureeColonne, String mois_debutColonne, String promotion_etuColonne) {

        this.nom_structureColonne = nom_structureColonne;
        this.sujetColonne = sujetColonne;
        this.lieuColonne = lieuColonne;
        this.dureeColonne = dureeColonne;
        this.mois_debutColonne = mois_debutColonne;
        this.promotion_etuColonne = promotion_etuColonne;
        
}

    private Main main;

    public StageModel(Main newMain){
        main = newMain;
    }

    private int id;
    private String nomStructure;
    private String sujetStage;
    private int duree;
    private String debutStage;
    private int promo;
    

    public StageModel (String nom_structureColonne, String sujetColonne, String lieuColonne, int dureeColonne, String mois_debutColonne, String promotion_etuColonne) {}

    public StageModel(int anInt, String string, String string1, int anInt1, String string2, int anInt2) {
    }

    public String nom_structureColonne() {
        String nom_structureColonne = " ";
        return nom_structureColonne;
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

    public int getId() {return id;}

    @Override
    public String toString() {
        return nomStructure;
    }



    /**
     * Permet de faire la requête des données de Stages dans la BDD et de l'ajouter dans la ListView
     * @param theListView
     */

//    public void addItemList(ListView theListView) throws IOException {
//
//        theListView.getItems().add(new Stage(i.getInt("ID_PREOP"), Tools.underscoreToSpace(i.getString("NOM_PREOP"))));
//    }


    /**
     * Permet d'envoyer la requête de suppression et de retirer l'élément de la ListView
     * @param theListView
     * @param leStage le tissu à supprimer
     */
//    public void removeItemList(ListView theListView, NotreClasseStage leStage, Text errorText) throws IOException {
//        BDD.deleteTissuRequest(leTissu.getIdTissue());
//    }
}

