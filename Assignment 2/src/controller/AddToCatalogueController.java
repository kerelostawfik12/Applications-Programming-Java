package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.io.InvalidObjectException;

public class AddToCatalogueController extends Controller<Catalogue> {
    @FXML private TextField partTypeTf;
    @FXML private TextField partNameTf;
    @FXML private TextField partPriceTf;
    @FXML private Button addToCatalogueBtn;

    public final Catalogue getCatalogue(){
        return model;
    }

    private String getType(){
        return partTypeTf.getText().toLowerCase();
    }

    private String getName(){
        return partNameTf.getText().toLowerCase();
    }

    private Double getPrice(){
        return Double.parseDouble(partPriceTf.getText().toLowerCase());
    }

    @FXML private void initialize(){

    }

    @FXML private void handleAdd() throws IOException {
        try {
                getCatalogue().addPart(getName(), getType(), getPrice());
                stage.close();

        }
        catch(NumberFormatException e) {
            ViewLoader.showStage(e, "/view/error.fxml", "Incorrect Input", new Stage());
        }
        }

    }


