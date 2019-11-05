import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.*;

public class LoginForm extends Application {
    public static void main(String[] args){
        launch(args);
    }

    private static final String CORRECT_USERNAME = "sam";
    private static final String CORRECT_PASSWORD = "mypassword";

    private Label usernameLbl;
    private TextField usernameTf;
    private Label passwordLbl;
    private PasswordField passwordPf;
    private Button loginBtn;
    private Text resultTxt;

    @Override public void start(Stage stage) throws Exception{
        GridPane grid = new GridPane();
        usernameLbl = new Label("Username:");
        grid.add(usernameLbl,0, 0);
        usernameTf = new TextField();
        grid.add(usernameTf,1,0);
        passwordLbl = new Label("Password:");
        grid.add(passwordLbl,0,1);
        passwordPf = new PasswordField();
        grid.add(passwordPf,1,1);
        loginBtn = new Button("Login");
        grid.add(loginBtn,1,2);
        resultTxt = new Text();
        grid.add(resultTxt,1,3);

        //set the event handler
        loginBtn.setOnAction(event -> {
            if (getUsername().equals(CORRECT_USERNAME) && getPassword().equals(CORRECT_PASSWORD))
                resultTxt.setText("Password correct!");
            else
                resultTxt.setText("Password incorrect!");
        });

        //Create a new branch node

        //Set the scene and show the stage
        stage.setScene(new Scene(grid));
        stage.setTitle("Login");
        stage.show();

    }

    private String getUsername(){
        return usernameTf.getText();
    }

    private String getPassword(){
        return passwordPf.getText();
    }

}
