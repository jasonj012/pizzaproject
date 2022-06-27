package PizzaProject.Service;

import PizzaProject.DAO.ProductDAO;
import PizzaProject.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductService //implements ProductServiceInterface
{
    ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts() {
        return productDAO.findAllProducts();
    }

    public Product getProductByName(String name) {
        return productDAO.findProductByName(name);
    }
    public Product getProductByID(int ID){
        return productDAO.findProductByID(ID);
    }
    public void addProduct(Product product) {
        productDAO.save(product);

    }

    public void deleteProductByName(String product){
        //      productDAO.delete(product);
    }

}
