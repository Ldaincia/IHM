package GPhyStages;

import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDD {

    //string contenant le lien vers la BDD
    private static final String location = BDD.class.getResource("database.db").toExternalForm();
    private static final String tableName = "offre_stage";

    public static String getLocation() {
        return location;
    }

    public static boolean checkDrivers() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            return true;
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not start SQLite Drivers");
            return false;
        }
    }


    /**
     * Permet de se connecter à la base de données
     * @param location contient le lien vers la bdd
     * @return connection de classe Connection
     */
    public static Connection connect(String location) {
        String dbPrefix = "jdbc:sqlite:";
        Connection connection;
        try {
            connection = DriverManager.getConnection(dbPrefix + location);
        }
        // gestion des erreurs
        catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                    LocalDateTime.now() + ": Could not connect to SQLite DB at " +
                            location);
            return null;
        }
        return connection;
    }

    /**
     * Ajout d'un stage
     */
    public static void insertStage(ObservableList<GPhyStages.NotreClasseStage> stages, String nom, String sub, String intitu, String adresse, int dur, String mois, String promo) {
        //update database
        int id = (int) CRUDHelper.create(
                tableName,
                new String[]{"nom_structure","sujet","intitule","lieu","duree","mois_debut","promotion_etu"},
                new Object[]{nom,sub,intitu,adresse,dur,mois,promo},
                new int[]{Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR,Types.VARCHAR});
        //update cache
        stages.add(new NotreClasseStage(id,nom,sub,adresse,dur,mois,promo));
    }

    /**
     * suppression d'un stage à partir de l'id
     */
//    public static int deleteStage(int id) {
//        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
//
//        try (Connection conn = connect(location)) {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, id);
//            return pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            Logger.getAnonymousLogger().log(
//                    Level.SEVERE,
//                    LocalDateTime.now() + ": Ne peut pas être supprimée de la table " + tableName +
//                            " car " + e.getCause());
//            return -1;
//        }
//    }
    public static void deleteStage(int id)
    {
        String query = "DELETE FROM NotreClasseStage WHERE id = ?";
        try (Connection connection = connect(location))
        {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void addStage(String nom_structure, String sujet, String lieu, int duree, String mois_debut, String promotion_etu)
    {


        String query = " INSERT INTO offre_stage VALUES (NULL, ?, ?, ?, ?, ?, ?, ?) ";
        try (Connection connection = connect(location))
        {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nom_structure);
            statement.setString(2, sujet);
            statement.setString(3, lieu);
            statement.setInt(4, duree);
            statement.setString(5, mois_debut);
            statement.setString(6, promotion_etu);
            statement.execute();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * modification d'un stage depuis l'id
     */
    public static void updateStage(ObservableList<GPhyStages.NotreClasseStage> stages, NotreClasseStage newStage) {
        //udpate database
        int rows = (int) CRUDHelper.update(
                "Stage",
                new String[]{"nom_structure","sujet","intitule","lieu","duree","mois_debut","promotion_etu"},
                new Object[]{newStage.getNom_structure(),newStage.getSujet(),newStage.getLieu(),
                        newStage.getDuree(),newStage.getMois_debut(),newStage.getPromotion_etu()},
                new int[]{Types.VARCHAR, Types.VARCHAR,Types.VARCHAR, Types.VARCHAR,Types.INTEGER,Types.VARCHAR, Types.VARCHAR},
                "num_offre",
                Types.INTEGER,
                newStage.getNum_offre()
        );

        if (rows == 0)
            throw new IllegalStateException("Person to be updated with id " + newStage.getNum_offre() + " didn't exist in database");

        //update cache
        Optional<NotreClasseStage> optionalStage = getStage(stages, newStage.getNum_offre());
        optionalStage.ifPresentOrElse((oldStage) -> {
            stages.remove(oldStage);
            stages.add(newStage);
        }, () -> {
            throw new IllegalStateException("Person to be updated with id " + newStage.getNum_offre() + " didn't exist in database");
        });
    }



    /**
     * selection des stages (toutes les lignes)
     * @return laListe
     */

    public static ArrayList<NotreClasseStage> selectionBDD() {
        ArrayList<NotreClasseStage> laListe = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;
        try (Connection connection = connect(location)) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                laListe.add(new NotreClasseStage(
                        rs.getInt("num_offre"),
                        rs.getString("nom_structure"),
                        rs.getString("sujet"),
                        rs.getString("lieu"),
                        rs.getInt("duree"),
                        rs.getString("mois_debut"),
                        rs.getString("promotion_etu")));
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not load Persons from database ");
        }
        return laListe;
    }

    /**
     * selection d'un stage à partir de l'id
     */
    public static Optional<NotreClasseStage> getStage(ObservableList<GPhyStages.NotreClasseStage> stages, int num){
        for (NotreClasseStage stage : stages) {
            if (stage.getNum_offre() == num) return Optional.of(stage);
        }
        return Optional.empty();
    }


}
