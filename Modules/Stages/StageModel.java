package Modules.Stages;
import GPhyStages.Main;

import java.io.IOException;

import GPhyStages.Stages;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StageModel {

    private Main main;

    public StageModel(Main newMain){
        main = newMain;
    }

    /**
     * Permet de faire la requête des données pré-opératoires dans la BDD et de l'ajouter dans la ListView
     * @param theListView
     */
    public void addItemList(ListView theListView) throws IOException {

        theListView.getItems().add(new Stages(i.getInt("ID_PREOP"), Tools.underscoreToSpace(i.getString("NOM_PREOP"))));
    }



    /**
     * Permet d'envoyer la requête de suppression et de retirer l'élément de la ListView
     * @param theListView
     * @param laDonnee la donnée pré-opératoire à supprimer
     */
    public void removeItemList(ListView theListView, Stages laDonnee, Text errorText) throws IOException {
        DataBase.deletePreopDataRequest(laDonnee.getIdPreop());

        if (checkPreopDataDeleted(laDonnee.getIdPreop())) {
            theListView.getItems().remove(laDonnee);
        } else {
            errorText.setText("Elément non supprimé, cette donnée pré-opératoire est encore liée à des phénotypes");
        }
    }
}


