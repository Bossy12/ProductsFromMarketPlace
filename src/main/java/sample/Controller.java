package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.entity.User;


public class Controller {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void loginButtonIsClicked() {
        User user = new User(username.getText(), password.getText());
      /*
        if(userExists(userList, user)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("You have logged in succesfully !");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have failed !!!!");
            alert.show();
        }
    }*/

}