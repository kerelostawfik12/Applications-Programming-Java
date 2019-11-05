package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class BuildController extends Controller<Build>{
    @FXML private TableView buildTv;
    @FXML private TableColumn<Part, String> typeClm;
    @FXML private TableColumn<Part, String> nameClm;
    @FXML private TableColumn<Part, String> priceClm;
    @FXML private Button checkBuildBtn;
    @FXML private Button removeFromBuildBtn;
    @FXML private Button closeBtn;
    @FXML private Text totalPriceTxt;

    public final Build getBuild(){
        return model;
    }

    @FXML private void initialize(){
        buildTv.setItems(getBuild().getParts());
        buildTv.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> removeFromBuildBtn.setDisable(newValue == null));
        getBuild().getParts().addListener(new ListChangeListener<Part>() {
            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Part> c) {
                totalPriceTxt.setText("$" + String.format("%.2f", getBuild().totalPrice()));
            }
        });
        buildTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        totalPriceTxt.setText("$" + String.format("%.2f", getBuild().totalPrice()));
        typeClm.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
    }

    @FXML private void handleRemove(){
        getBuild().remove(buildTv.getSelectionModel().getSelectedItems());
    }

    @FXML private void handleCheck() throws IOException {
        ViewLoader.showStage(getBuild(), "/view/buildcheck.fxml", "Build Validity Status", new Stage());
    }

    @FXML private void handleClose(){
        stage.close();
    }
}
