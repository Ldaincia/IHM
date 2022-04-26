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

