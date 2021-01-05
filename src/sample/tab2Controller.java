package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class tab2Controller implements Initializable {
    @FXML
    private TextField idPrpprietaire;
    @FXML
    private TextField nomPropietaire;
    @FXML
    private TextField prenomProprietaire;
    @FXML
    private TextField adressProprietaire;
    @FXML
    private TextField contactProprietaire;
    @FXML
    private TableView<Proprietaire> tableProprietaire;
    @FXML
    private TableColumn<Proprietaire, Integer> tbIdProp;
    @FXML
    private TableColumn<Proprietaire, String> tbNomProprietaire;
    @FXML
    private TableColumn<Proprietaire, String> tbPrenomProp;
    @FXML
    private TableColumn<Proprietaire, String> tbAdressProp;
    @FXML
    private TableColumn<Proprietaire, String> tbContactProp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tbIdProp.setCellValueFactory(new PropertyValueFactory<>("idProp"));
        tbNomProprietaire.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tbPrenomProp.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tbAdressProp.setCellValueFactory(new PropertyValueFactory<>("adress"));
        tbContactProp.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tableProprietaire.setItems(getProprietaireList());

        //This will allow the table to select multiple rows at once
        tableProprietaire.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    ObservableList<Proprietaire> getProprietaireList(){
        ObservableList<Proprietaire> proprietaires = FXCollections.observableArrayList();
        proprietaires.add(new Proprietaire(1, "Meriem", "Ben", "Marrakech", "06666666"));
        proprietaires.add(new Proprietaire(2, "Meriem", "Ben", "Marrakech", "06666666"));

        return proprietaires;
    }

    public void AjouterProprietaire(ActionEvent event) {
        Proprietaire proprietaire = new Proprietaire();
        proprietaire.setIdProp(Integer.parseInt(idPrpprietaire.getText()));
        proprietaire.setNom(nomPropietaire.getText());
        proprietaire.setPrenom(prenomProprietaire.getText());
        proprietaire.setAdress(adressProprietaire.getText());
        proprietaire.setContact(contactProprietaire.getText());
        tableProprietaire.getItems().add(proprietaire);

        idPrpprietaire.clear();
        nomPropietaire.clear();
        prenomProprietaire.clear();
        adressProprietaire.clear();
        contactProprietaire.clear();
    }

    public void supprimerProprietaire(ActionEvent event) {
        ObservableList<Proprietaire> selectedRows, allProprietaire;
        allProprietaire = tableProprietaire.getItems();

        //this gives us the rows that were selected
        selectedRows = tableProprietaire.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the objects from the table
        for (Proprietaire proprietaire: selectedRows)
        {
            allProprietaire.remove(proprietaire);
        }
    }
}
