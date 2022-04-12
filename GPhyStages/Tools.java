package GPhyStages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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
            switchScene(stage, "Menu/Menu.fxml", main.getMenuController());
            main.getMenuController().updateMenu();
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

        public ArrayList<JSONObject> splitResultQuery(String objectToSplit) {

            ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
            int pos1 = 0;
            int pos2 = 0;
            for (int i = 0; i < objectToSplit.length(); i++) {

                JSONObject newJsonObject = null;

                if (objectToSplit.charAt(i) == '{') {
                    pos1 = i;
                } else if (objectToSplit.charAt(i) == '}') {
                    pos2 = i + 1;
                    newJsonObject = new JSONObject(objectToSplit.substring(pos1, pos2));
                    jsonList.add(newJsonObject);
                }
            }


            return jsonList;
        }


        public ArrayList<JSONObject> sendRequest(String request) throws IOException {
            ArrayList<JSONObject> listOfResults = null;

            URL url = new URL(request);
            URLConnection conn = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                String output = inputLine.replace("[", "").replace("]", "");
                ;
                listOfResults = splitResultQuery(output);
            }
            return listOfResults;
        }
}
