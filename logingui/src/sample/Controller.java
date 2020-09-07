package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML TextField email;
    @FXML PasswordField password;
    @FXML Label result;
    @FXML Pane rootPane;
    DBHelper dbHelper=new DBHelper();
    public void onClick(MouseEvent mouseEvent) throws IOException {
        boolean response=dbHelper.login(email.getText(),password.getText());

        if(response){
            //result.setText("Login Successful");
            Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
            rootPane.getChildren().setAll(root);
        }else{
            result.setText("Login Unsuccessful");
        }
    }

    public void launchRegister(MouseEvent mouseEvent) throws IOException {
        // launch register.fxml

        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        rootPane.getChildren().setAll(root);
    }
}
