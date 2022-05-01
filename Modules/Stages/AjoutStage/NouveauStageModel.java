package Modules.Stages.AjoutStage;

public class NouveauStageModel {


    private String nom_structureColonne;
    private String sujetColonne;
    private String lieuColonne;
    private int dureeColonne;
    private String mois_debutColonne;
    private String promotion_etuColonne;


    public NouveauStageModel (String nom_structureColonne, String sujetColonne, String lieuColonne, int dureeColonne, String mois_debutColonne, String promotion_etuColonne) {
    }

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


}

