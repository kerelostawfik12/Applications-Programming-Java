package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.*;


public class ComputerBuilderController extends Controller<ComputerBuilder>{
    @FXML private Button exitBtn;
    @FXML private Button viewCatalogueBtn;
    @FXML private Button viewBuildBtn;

    public final ComputerBuilder getComputerBuilder(){
        return model;
    }


    @FXML private void initialize(){
    }

    @FXML private void handleViewCatalogue() throws Exception{
        ViewLoader.showStage(getComputerBuilder().getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }

    @FXML private void handleViewBuild() throws Exception{
        ViewLoader.showStage(getComputerBuilder().getBuild(), "/view/build.fxml", "Current build", new Stage());
    }

    @FXML private void handleQuit(){
        Platform.exit();
    }
}