package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.hibernate.Session;
import sample.Utils.HibernateUtil;
import sample.Utils.ProductDao;
import sample.entity.Product;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class CustomerController implements Initializable {

    @FXML
    TableView<Product> productTable;
    @FXML
    TableColumn<Product, String> nameOfProduct;
    @FXML
    TableColumn<Product, Integer> priceOfProduct;
    @FXML
    TableColumn<Product, Integer> quantity;
    @FXML
    private Label wantToBuyLabel;


    private static Session session = HibernateUtil.getSession();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameOfProduct.setCellValueFactory(new PropertyValueFactory<>("productName"));
        priceOfProduct.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        showAllProducts();
    }

    @FXML
    void onReturnClicked() throws IOException {
        Main.showParentScene();
    }

    @FXML
    public void onSelectProductClicked() {

    }

    @FXML
    void onBuyProductClicked() {
        String productToBuy = productTable.getSelectionModel().getSelectedItem()
                .toString().split(",")[1].split("=")[1];
        wantToBuyLabel.setText("You select: " + productToBuy);
        String productId = productTable.getSelectionModel().getSelectedItem()
                .toString().split(",")[0].split("=")[1];

        int numberProductId = 0;
        for (int i = 0; i < productId.length(); i++) {
            char character = productId.charAt(i);
            if (Character.isDigit(character))
                numberProductId = Integer.parseInt(String.valueOf(character));
        }
        ProductDao product = new ProductDao();
        // -- to see what product is selected when press button << Buy Product >>
        Product productBuying = product.getProduct(numberProductId);
        System.out.println(productBuying);
    }

    @FXML
    public void selectOneProduct(MouseEvent mouseEvent) {
        /*ProductDao product = new ProductDao();
        List<Product> result = product.getAllProducts();*/

        ObservableList<Product> selectedProduct = productTable.getSelectionModel().getSelectedItems();
        String productName = selectedProduct.toString().split(",")[1].split("=")[1];
        System.out.println(productName);

    }

    public void showAllProducts() {
        ProductDao products = new ProductDao();
        List<Product> result = products.getAllProducts();
        ObservableList<Product> observableArrayList;
        observableArrayList = FXCollections.observableArrayList(result);
        productTable.setItems(observableArrayList);
    }
}
