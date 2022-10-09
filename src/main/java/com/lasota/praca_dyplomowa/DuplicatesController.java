package com.lasota.praca_dyplomowa;

import com.lasota.praca_dyplomowa.classes.Checksum;
import com.lasota.praca_dyplomowa.classes.FileInfo;
import com.lasota.praca_dyplomowa.classes.GetFiles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DuplicatesController {

    File directory = null;
    Alert a = new Alert(Alert.AlertType.NONE);
    Stage stage;
    Scene scene;
    Parent root;

    @FXML
    private TableColumn<FileInfo, String> checksumId;

    @FXML
    private TableColumn<FileInfo, String> duplicateFilesId;

    @FXML
    private TableColumn<FileInfo, String> fileNameId;

    @FXML
    private TableView<FileInfo> tableId;

    @FXML
    Label testLabel;

    @FXML
    void searchDuplicates(ActionEvent event) throws NoSuchAlgorithmException, IOException {
        if(directory != null){
            fileNameId.setCellValueFactory(new PropertyValueFactory<FileInfo, String>("fileName"));
            checksumId.setCellValueFactory(new PropertyValueFactory<FileInfo, String>("checksum"));
            duplicateFilesId.setCellValueFactory(new PropertyValueFactory<FileInfo, String>("duplicateFiles"));
            ArrayList<FileInfo> fileInfoList = new ArrayList<>();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            GetFiles getFiles = new GetFiles();
            getFiles.getAllFilesFromDirectoryName(directory.getAbsolutePath());
            for(File file : getFiles.getFileList()){
                FileInfo fileInfo = new FileInfo();
                fileInfo.setFileName(file.getName());
                fileInfo.setChecksum(Checksum.getChecksum(md, file));
                fileInfo.setDuplicateFiles("");
                fileInfoList.add(fileInfo);
            }
            fileInfoList = searchDuplicates(fileInfoList);
            ObservableList<FileInfo> observableList = FXCollections.observableList(fileInfoList);
            tableId.setItems(observableList);

        }
    }

    ArrayList<FileInfo> searchDuplicates(ArrayList<FileInfo> fileInfoList){
        for(int i=0; i<fileInfoList.size(); i++){
            for(int j=i+1; j<fileInfoList.size(); j++){
                if(fileInfoList.get(i).getChecksum().equals(fileInfoList.get(j).getChecksum()) ){
                    StringBuilder sb = new StringBuilder(fileInfoList.get(i).getDuplicateFiles());
                    fileInfoList.get(i).setDuplicateFiles(sb.append(" "+fileInfoList.get(j).getFileName()).toString());
                    sb = new StringBuilder(fileInfoList.get(j).getDuplicateFiles());
                    fileInfoList.get(j).setDuplicateFiles(sb.append(" "+fileInfoList.get(i).getFileName()).toString());
                }
            }
        }
        return fileInfoList;
    }
    @FXML
    void changeSceneMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void folderChooser(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Wybierz folder");
        File defaultDirectory = new File(".");
        chooser.setInitialDirectory(defaultDirectory);
        directory = chooser.showDialog(null);
        if(directory != null){
            testLabel.setText(directory.getAbsolutePath());
        }
    }
}
