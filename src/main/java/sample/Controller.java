package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.usertype.UserType;
import sample.entity.User;


import java.io.IOException;


public class Controller {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    public void loginButtonIsClicked(ActionEvent event) throws IOException {
        User user = new User();
        user.setUsername(username.getText());
        user.setPassword(password.getText());

        UserVerifier userVerifier = new UserVerifier();
        if (userVerifier.userExist(user) && userVerifier.isUserEmployeeType(user)) {

            Scene scene = new Scene(parent);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have failed !!!!");
            alert.show();
        }
    }
}
