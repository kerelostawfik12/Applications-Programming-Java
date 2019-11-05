package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
import model.Part;


public class CatalogueController extends Controller<Catalogue> {
    @FXML private TableView<Part> catalogueTv;
    @FXML private TableColumn<Part, String> typeClm;
    @FXML private TableColumn<Part, String> nameClm;
    @FXML private TableColumn<Part, String> priceClm;
    @FXML private Button addToCatalogueBtn;
    @FXML private Button addToBuildBtn;
    @FXML private Button removeFromCatalogueBtn;
    @FXML private Button closeBtn;
    @FXML private TextField typeFilterTf;
    @FXML private TextField minPriceFilterTf;
    @FXML private TextField maxPriceFilterTf;

    public final Catalogue getCatalogue(){
        return model;
    }

    private String getType() {
        return typeFilterTf.getText();
    }

    private String getMinPrice(){
        return minPriceFilterTf.getText().toLowerCase();
    }

    private String getMaxPrice(){
        return maxPriceFilterTf.getText().toLowerCase();
    }


    @FXML private void handleClose(){
        stage.close();
    }

    @FXML private void handleAddToBuild(){
        getCatalogue().addToBuild(catalogueTv.getSelectionModel().getSelectedItems());
    }

    @FXML private void handleRemoveFromCatalogue(){
        getCatalogue().remove(catalogueTv.getSelectionModel().getSelectedItems());
    }

    @FXML private void handleAddToCatalogue() throws Exception{
        ViewLoader.showStage(getCatalogue(), "/view/addtocatalogue.fxml", "Add New Part To Catalogue", new Stage());
    }

    @FXML private void handleFilterType(){
        getCatalogue().filterList(getType(), getMinPrice(), getMaxPrice());
    }

    @FXML private void initialize(){
        catalogueTv.setItems(getCatalogue().getCurrentView());
        catalogueTv.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            addToBuildBtn.setDisable(newValue == null);
            removeFromCatalogueBtn.setDisable(newValue == null);
        });
        catalogueTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        typeClm.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
        typeFilterTf.textProperty().addListener((observable, oldValue, newValue) ->
            getCatalogue().filterList(getType(), getMinPrice(), getMaxPrice()));
        minPriceFilterTf.textProperty().addListener((observable, oldValue, newValue) ->
            getCatalogue().filterList(getType(), getMinPrice(), getMaxPrice()));
        maxPriceFilterTf.textProperty().addListener((observable, oldValue, newValue) ->
            getCatalogue().filterList(getType(), getMinPrice(), getMaxPrice()));




    }

}
