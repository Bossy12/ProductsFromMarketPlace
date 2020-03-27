package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.Utils.HibernateUtil;
import sample.entity.Product;

import java.io.IOException;
import java.util.List;

public class EmployeeController {

    @FXML
    TableView<Product> productTable;
    @FXML
    TableColumn<Product, String> nameOfProduct;
    @FXML
    TableColumn<Product, Integer> priceOfProduct;
    @FXML
    TableColumn<Product, Integer> quantity;

    private static Session session = HibernateUtil.getSession();

    @FXML
    void onReturnClicked() throws IOException {
        Main.showParentScene();
    }

    @FXML
    public void initialize() {
        nameOfProduct.setCellValueFactory(new PropertyValueFactory<>("productName"));
        priceOfProduct.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Query<Product> query = session.createQuery(
                "select p from Product p", Product.class);
        List<Product> results = query.list();
        ObservableList<Product> observableArrayList =
                FXCollections.observableArrayList(results);
        productTable.setItems(observableArrayList);
    }
}
