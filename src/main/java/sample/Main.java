package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sample.Utils.HibernateUtil;

import java.io.IOException;

public class Main extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showParentScene();

    }

    public static void showParentScene() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/home.fxml"));
        primaryStage.setTitle("ProductsFromMarketPlace");
        primaryStage.setScene(new Scene(root, 500, 375));
        primaryStage.show();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
    }

    public static void main(String[] args) {launch(args); }
}
