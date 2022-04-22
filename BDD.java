import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDD {

    //string contenant le lien vers la BDD sur GitHub
    private static final String location = "https://github.com/Ldaincia/IHM/blob/main/Database/database.db";

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

    public static void insertStage(String nom, String sub, String intitu, String adresse, int dur, String mois, String promo) {
        //update database
        int id = (int) CRUDHelper.create(
                "Stage",
                new String[]{"nom_structure","sujet","intitule","lieu","duree","mois_debut","promotion_etu"},
                new Object[]{nom,sub,intitu,adresse,dur,mois,promo},
                new int[]{Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR,Types.VARCHAR});
        //update cache
        stages.add(new Stage(id,nom,sub,intitu,adresse,dur,mois,promo));
    }

    /**
     * suppression d'un stage à partir de l'id
     */
    public static int deleteStage(String tableName, int id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

        try (Connection conn = connect(location)) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not delete from " + tableName + " by id " + id +
                            " because " + e.getCause());
            return -1;
        }
    }

    /**
     * modification d'un stage depuis l'id
     */
    public static void updateStage(Stage newStage) {
        //udpate database
        int rows = (int) CRUDHelper.update(
                "Stage",
                new String[]{"nom_structure","sujet","intitule","lieu","duree","mois_debut","promotion_etu"},
                new Object[]{newStage.getNom_structure(),newStage.getSujet(),newStage.getIntitule(),newStage.getLieu(),
                        newStage.getDuree(),newStage.getMois_debut(),newStage.getPromotion_etu()},
                new int[]{Types.VARCHAR, Types.VARCHAR,Types.VARCHAR, Types.VARCHAR,Types.INTEGER,Types.VARCHAR, Types.VARCHAR},
                "num_offre",
                Types.INTEGER,
                newStage.getNum_offre()
        );

        if (rows == 0)
            throw new IllegalStateException("Person to be updated with id " + newStage.getNum_offre() + " didn't exist in database");

        //update cache
        Optional<Stage> optionalStage = getStage(newStage.getNum_offre());
        optionalStage.ifPresentOrElse((oldStage) -> {
            stages.remove(oldStage);
            stages.add(newStage);
        }, () -> {
            throw new IllegalStateException("Person to be updated with id " + newStage.getNum_offre() + " didn't exist in database");
        });
    }



    /**
     * selection des stages (toutes les lignes)
     */

    private static final String tableName = "OFFRE_STAGE";
    private static final ObservableList<Stage> stages;
    static{stages = FXCollections.observableArrayList();}

    public static void selectionBDD() {
        String query = "SELECT * FROM " + tableName;
        try (Connection connection = connect(location)) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            stages.clear();
            while (rs.next()) {
                stages.add(new Stage(
                        rs.getInt("num_offre"),
                        rs.getString("nom_structure"),
                        rs.getString("sujet"),
                        rs.getString("intitule"),
                        rs.getString("lieu"),
                        rs.getInt("duree"),
                        rs.getString("mois_debut"),
                        rs.getString("promotion_etu")));
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not load Persons from database ");
            stages.clear();
        }
    }

    /**
     * selection d'un stage à partir de l'id
     */
    public static Optional<Stage> getStage(int num){
        for (Stage stage : stages) {
            if (stage.getNum_offre() == num) return Optional.of(stage);
        }
        return Optional.empty();
    }
}
