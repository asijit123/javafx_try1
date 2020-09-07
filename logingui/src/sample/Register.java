package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Register {

    @FXML AnchorPane registerUI;
    @FXML TextField name;
    @FXML TextField email;
    @FXML PasswordField password;
    @FXML Label result;
    DBHelper dbHelper=new DBHelper();

    public void performSignup(MouseEvent mouseEvent){
        boolean response=dbHelper.register(name.getText(),email.getText(),password.getText());
        if(response){
            result.setText("Registration Succeccful.Login to Proceed");
        }else{
            result.setText("reg Failed");
        }
    }
    public void loadlogin(MouseEvent mouseEvenr) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        registerUI.getChildren().setAll(root);
    }

}
