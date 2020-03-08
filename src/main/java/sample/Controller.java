package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


import java.io.IOException;

public class Controller {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void loginButtonIsClicked(ActionEvent event) throws IOException {
        User user = new User(username.getText(), password.getText());
        Database database = new Database();
        List<User> userList = database.getUsers();
        if(userExists(userList, user)){
            Parent parent = FXMLLoader.load(getClass().getResource("secondscreen.fxml"));
            Scene scene = new Scene(parent);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("You have logged in succesfully!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User unknown, please register!");
            alert.show();
        }
    }

    public void buttonIsClicked() {
        System.out.println("Button is pressed");
    }

    private boolean userExists(List<User> users, User user) {
        for(User each:users) {
            if(each.equals(user)) {
                return true;
            }
        }
        return false;
    }

}