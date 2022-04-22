public class Stage {

    public int num_offre;
    public String nom_structure;
    public String sujet;
    public String intitule;
    public String lieu;
    public int duree;
    public String mois_debut;
    public String promotion_etu;

    public Stage(int id, String nom, String sub, String intitu, String adresse, int dur, String mois, String promo){
        num_offre = id;
        nom_structure = nom;
        sujet = sub;
        intitule = intitu;
        lieu = adresse;
        duree = dur;
        mois_debut = mois;
        promotion_etu = promo;
    }

    public int getNum_offre() {
        return num_offre;
    }

    public String getNom_structure() {
        return nom_structure;
    }

    public String getSujet(){
        return sujet;
    }

    public String getIntitule(){
        return intitule;
    }

    public String getLieu() {
        return lieu;
    }

    public int getDuree() {
        return duree;
    }

    public String getMois_debut() {
        return mois_debut;
    }

    public String getPromotion_etu() {
        return promotion_etu;
    }
}
