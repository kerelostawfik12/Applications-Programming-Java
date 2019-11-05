package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;

public class ErrorController extends Controller<Exception> {
    public final Exception getException(){
        return model;
    }


    @FXML private void handleOk(){
        stage.close();

    }

}
