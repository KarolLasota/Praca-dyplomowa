package com.lasota.praca_dyplomowa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class HomeController {
    Stage stage;
    Scene scene;
    Parent root;

    @FXML
    void changeScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("duplicates-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}
