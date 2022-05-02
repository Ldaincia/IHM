package GPhyStages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Tools {

        private Main main;
        private Scene previousScene;

        public Tools(Main newMain) {
            main = newMain;
        }

        public void switchScene(Stage stage, String nameFXML, Object controller) throws IOException {
            FXMLLoader newFXML = new FXMLLoader(getClass().getResource(nameFXML));
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

        /*
        public void goHome(Button button) throws IOException, SQLException {
            Stage stage = (Stage) button.getScene().getWindow();
            switchScene(stage, "Accueil/Accueil.fxml", main.getAccueilController());
        }
        */


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
