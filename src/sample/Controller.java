package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab gestionImmo;
    @FXML
    private Tab gestionPropr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXMLLoader loader = new FXMLLoader();
        try
        {
            AnchorPane anch1 = loader.load(getClass().getResource("tab1.fxml"));
            gestionImmo.setContent(anch1);
        }
        catch(IOException iex)
        {
            System.out.println("File not found");
        }
        loader = new FXMLLoader();
        try
        {
            AnchorPane anch2 = loader.load(getClass().getResource("tab2.fxml"));
            gestionPropr.setContent(anch2);
        }
        catch(IOException iex)
        {
            System.out.println("File not found");
        }
    }


}
