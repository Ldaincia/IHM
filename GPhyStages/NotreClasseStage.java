package GPhyStages;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NotreClasseStage {

    private final IntegerProperty num_offre;
    private final StringProperty  nom_structure;
    private final StringProperty  sujet;
    private final StringProperty  intitule;
    private final StringProperty  lieu;
    private final IntegerProperty duree;
    private final StringProperty  mois_debut;
    private final StringProperty  promotion_etu;

    public NotreClasseStage(int num_offre, String nom_structure, String sujet, String intitule, String lieu, int duree, String mois_debut, String promotion_etu){
        this.num_offre = new SimpleIntegerProperty(num_offre);
        this.nom_structure = new SimpleStringProperty(nom_structure);
        this.sujet = new SimpleStringProperty(sujet);
        this.intitule = new SimpleStringProperty(intitule);
        this.lieu = new SimpleStringProperty(lieu);
        this.duree = new SimpleIntegerProperty(duree);
        this.mois_debut = new SimpleStringProperty(mois_debut);
        this.promotion_etu = new SimpleStringProperty(promotion_etu);
    }

    public int getNum_offre() {
        return num_offre.get();
    }
    public void setNum_Offre(int num_offre){this.num_offre.set(num_offre);}
    public IntegerProperty num_offreProperty(){return num_offre;}

    public String getNom_structure() {
        return nom_structure.get();
    }
    public void setNom_structure(String nom_structure){this.nom_structure.set(nom_structure);}
    public StringProperty nom_structureProperty(){return nom_structure;}

    public String getSujet(){
        return sujet.get();
    }
    public void setSujet(String sujet){this.sujet.set(sujet);}
    public StringProperty sujetProperty(){return sujet;}

    public String getIntitule(){
        return intitule.get();
    }
    public void setIntitule(String intitule){this.intitule.set(intitule);}
    public StringProperty intutileProperty(){return intitule;}

    public String getLieu() {
        return lieu.get();
    }
    public void setLieu(String lieu){this.lieu.set(lieu);}
    public StringProperty lieuProperty(){return lieu;}

    public int getDuree() {
        return duree.get();
    }
    public void setDuree(int duree){this.duree.set(duree);}
    public IntegerProperty dureeProperty(){return duree;}

    public String getMois_debut() {
        return mois_debut.get();
    }
    public void setMois_debut(String mois_debut){this.mois_debut.set(mois_debut);}
    public StringProperty mois_debutProperty(){return mois_debut;}

    public String getPromotion_etu() {
        return promotion_etu.get();
    }
    public void setPromotion_etu(String promotion_etu){this.promotion_etu.set(promotion_etu);}
    public StringProperty promotion_etuProperty(){return promotion_etu;}
}
