import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.scene.layout.GridPane.*;


public class Calculator extends Application {
    public static void main(String[] args) { launch(args); }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        firstNumberLbl = new Label("First number:");
        grid.add(firstNumberLbl, 0, 0);
        firstNumberTf = new TextField("");
        grid.add(firstNumberTf,1, 0);
        secondNumberLbl = new Label("Second number:");
        grid.add(secondNumberLbl,0, 1);
        secondNumberTf = new TextField("");
        grid.add(secondNumberTf,1,1);
        operationLbl = new Label("Operation:");
        grid.add(operationLbl,0,2);
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        grid.add(resultLbl,0,3);
        resultTf = new TextField("");
        grid.add(resultTf,1,3);

        // 2. create the branch node'
        HBox box = new HBox(4, addBtn, subBtn, mulBtn, divBtn);
        grid.add(box,1,2);
        //2.5 Event Handlers
        addBtn.setOnAction(new AddHandler());
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                subtract(getFirstNumber(), getSecondNumber());
            }
        });
        mulBtn.setOnAction(event -> setResult(getFirstNumber()*getSecondNumber()));
        divBtn.setOnAction(event -> setResult(getFirstNumber()/getSecondNumber()));
        // 3. set the scene, show the stage
        stage.setScene(new Scene(grid));
        stage.setTitle("Calculator");
        stage.show();
    }

    public int getFirstNumber(){
        return Integer.parseInt(firstNumberTf.getText());
    }

    public int getSecondNumber(){
        return Integer.parseInt(secondNumberTf.getText());
    }

    public void setResult(int value){
        resultTf.setText(String.valueOf(value));
    }
    public void subtract(int first, int second){
        int result = first - second;
        setResult(result);
    }

    private class AddHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            setResult(getFirstNumber() + getSecondNumber());
        }
    }





}