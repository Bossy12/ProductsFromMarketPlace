package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.mapping.Table;
import org.hibernate.query.Query;
import sample.Utils.HibernateUtil;
import sample.entity.Product;

import java.io.IOException;
import java.util.List;

public class CustomerController {

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

    public static List<Product> nameOfProducts(Product product) {
        Query<Product> query = session.createQuery(
                "select p from Product p", Product.class);
        return query.getResultList();
    }
}
