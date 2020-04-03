package sample;

import com.sun.javafx.collections.MappingChange;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.Utils.HibernateUtil;
import sample.Utils.ProductDao;
import sample.entity.Product;

import java.io.IOException;
import java.util.*;

public class CustomerController {

    @FXML
    TableView<ProductDao> productTable;
    @FXML
    TableColumn<Product, String> nameOfProduct;
    @FXML
    TableColumn<Product, Integer> priceOfProduct;
    @FXML
    TableColumn<Product, Integer> quantity;
    @FXML
    private Label wantToBuyLabel;


    private static Session session = HibernateUtil.getSession();

    @FXML
    public void initialize() {
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
    void onBuyProductClicked(){
       wantToBuyLabel.setText("You select: " + productTable.getSelectionModel().getSelectedItem());

    }

    @FXML
    public void selectOneProduct(MouseEvent mouseEvent){
        List<ProductDao> name = Collections.singletonList(productTable.getSelectionModel().getSelectedItem());
        Iterator iterator = name.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());}
        //System.out.println(iterator.hashCode());
    }
    public void showAllProducts(){
        ProductDao products = new ProductDao();
        List<ProductDao> result = products.getAllProducts();
        ObservableList<ProductDao> observableArrayList;
        observableArrayList = FXCollections.observableArrayList (result);
        productTable.setItems(observableArrayList);
    }
}
