package sample;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.entity.Product;
import sample.entity.User;

import java.util.List;

public class UserUtil {

    private Session session = HibernateUtil.getSession();

    public double buyProduct(User user, Product selectedProduct, int quantity) {

        confirmPayment();
        return 1;
    }

    public void confirmPayment() {

    }

    // TODO: 3/8/2020  
    public void addProduct(Product productToAdd, int quantity) {
        session.beginTransaction();

//        update product set quantity = 100 where product_name = 'TV LCD';
        Query<Product> readQuery = session.createQuery(
                "select p from Product p where p.productName = :productName", Product.class);
        readQuery.setParameter("productName", productToAdd.getProductName());
        List<Product> resultProduct = readQuery.getResultList();

        Query updateQuery = session.createQuery("update Product p set p.quantity = :increment where p.productName = :productName", Product.class );
        updateQuery.setParameter("increment", resultProduct.get(0).getQuantity() + quantity);
        updateQuery.setParameter("productName",productToAdd.getProductName());
        session.save(productToAdd);
        session.getTransaction().commit();
        session.close();

    }

    public void removeProduct(Product productToRemove, int quantity) {

    }

}
