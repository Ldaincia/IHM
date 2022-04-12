package GPhyStages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


public class Tools {

        private Main main;
        private Scene previousScene;

        public Tools(Main newMain) {
            main = newMain;
        }

        public void switchScene(Stage stage, String nameFXML, Object controller) throws IOException {
            FXMLLoader newFXML = new FXMLLoader(getClass().getResource("/Modules/" + nameFXML));
            newFXML.setController(controller);
            Parent pane = (Parent) newFXML.load();
            previousScene = stage.getScene();
            stage.setScene(new Scene(pane));
            stage.show();
        }

        public void previous(Stage stage) {
            stage.setScene(previousScene);
            stage.show();
        }


        public void goHome(Button button) throws IOException, SQLException {
            Stage stage = (Stage) button.getScene().getWindow();
            switchScene(stage, "Accueil/Accueil.fxml", main.getAccueilController());
        }


        public static String spaceToUnderscore(String textToTransform) {
            String textTransform = textToTransform;
            for (int i = 0; i < textToTransform.length(); i++) {

                if (textToTransform.charAt(i) == ' ') {
                    textTransform = textTransform.substring(0, i) + '_' + textTransform.substring(i + 1);
                }
            }
            return textTransform;
        }


        public static String underscoreToSpace(String textToTransform) {
            String textTransform = textToTransform;
            for (int i = 0; i < textToTransform.length(); i++) {

                if (textToTransform.charAt(i) == '_') {
                    textTransform = textTransform.substring(0, i) + ' ' + textTransform.substring(i + 1);
                }
            }
            return textTransform;
        }
}
