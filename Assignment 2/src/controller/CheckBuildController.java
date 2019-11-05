package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Build;



public class CheckBuildController extends Controller<Build> {

    @FXML private Label missingBuildLbl;

    public final Build getBuild() {
        return model;
    }


    @FXML private void initialize() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        for (String s : getBuild().validBuild()) {
            if (!(getBuild().isValid()) && (!(getBuild().hasPartOfType("cpu"))) && s.equals("CPU"))
                s1 += "The build is missing a " + s + ".\n";
            if (!(getBuild().isValid()) && (!(getBuild().hasPartOfType("motherboard"))) && s.equals("motherboard"))
                s2 += "The build is missing a " + s + ".\n";
            if (!(getBuild().isValid()) && (!(getBuild().hasPartOfType("memory"))) && s.equals("memory"))
                s3 += "The build is missing RAM.\n";
            if (!(getBuild().isValid()) && (!(getBuild().hasPartOfType("case"))) && s.equals("case"))
                s4 += "The build is missing a " + s + ".\n";
            if (!(getBuild().isValid()) && (!(getBuild().hasPartOfType("storage"))) && s.equals("storage"))
                s5 += "The build is missing " + s + ".\n";


        }
        missingBuildLbl.setText(s1 + s2 + s3 + s4 + s5);
        if (missingBuildLbl.textProperty().getValue() == "")
            missingBuildLbl.setText("The build is functional.");
    }





    @FXML private void handleClose () {
        stage.close();
    }
}
