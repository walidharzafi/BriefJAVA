package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class tab1Controller implements Initializable {

    @FXML
    private TextField idImmobilier;
    @FXML
    private TextField typeImmobilier;
    @FXML
    private TextField surfaceImmobilier;
    @FXML
    private TextField adressImmobilier;
    @FXML
    private TextField prixImmobilier;
    @FXML
    private TableView<Immobilier> tableImmo;
    @FXML
    private TableColumn<Immobilier, Integer> tbIdImmo;
    @FXML
    private TableColumn<Immobilier, String> tbTypeImmo;
    @FXML
    private TableColumn<Immobilier, String> tbSurfaceImmo;
    @FXML
    private TableColumn<Immobilier, String> tbAdressImmo;
    @FXML
    private TableColumn<Immobilier, Integer> tbPrixImmo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Defines how to fill data for each cell.
        // Get value from property of Immobilier.

        tbIdImmo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbTypeImmo.setCellValueFactory(new PropertyValueFactory<>("type"));
        tbSurfaceImmo.setCellValueFactory(new PropertyValueFactory<>("surface"));
        tbAdressImmo.setCellValueFactory(new PropertyValueFactory<>("adress"));
        tbPrixImmo.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tableImmo.setItems(getImmobilierList());

        tableImmo.setEditable(true);

        //This will allow the table to select multiple rows at once
        tableImmo.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    // Display row data
    ObservableList<Immobilier> getImmobilierList(){
        ObservableList<Immobilier> immobiliers = FXCollections.observableArrayList();
        immobiliers.add(new Immobilier(1, "villa", "mm", "nn", 11));
        immobiliers.add(new Immobilier(2, "Appartement", "mm", "nn", 11));
        immobiliers.add(new Immobilier(3, "Mini Villa", "mm", "nn", 11));
        return immobiliers;
    }

    public void AjouterImmob(ActionEvent event) {
        if(idImmobilier.getText().equals("") || typeImmobilier.getText().equals("")|| surfaceImmobilier.getText().equals("")|| adressImmobilier.getText().equals("") || prixImmobilier.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setContentText("s'il vous plait compeleter les informations");
            alert.show();

        }
        else {
            Immobilier immo = new Immobilier();
            immo.setId(Integer.parseInt(idImmobilier.getText()));
            immo.setType(typeImmobilier.getText());
            immo.setSurface(surfaceImmobilier.getText());
            immo.setAdress(adressImmobilier.getText());
            immo.setPrix(Integer.parseInt(prixImmobilier.getText()));
            tableImmo.getItems().add(immo);
            idImmobilier.clear();
            typeImmobilier.clear();
            surfaceImmobilier.clear();
            adressImmobilier.clear();
            prixImmobilier.clear();


        }
    }

    public void SupprimerImmobilier(ActionEvent event) {
        ObservableList<Immobilier> selectedRows, allImmobil;
        allImmobil = tableImmo.getItems();

        //this gives us the rows that were selected
        selectedRows = tableImmo.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the objects from the table
        for (Immobilier immobilier: selectedRows)
        {
            allImmobil.remove(immobilier);
        }
    }
}
