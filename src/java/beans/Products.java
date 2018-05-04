package beans;

import java.util.ArrayList;

/**
 *
 * @author dmitry
 */
public class Products {
    
    private static ArrayList <Product> PRODUCTS = new ArrayList<>();
    
    private Products(){}
    
    public ArrayList<Product> getUSERS(){
        return PRODUCTS;
    }
    
    public User getProductById(int id){
        return null;
    }
    
    public User getProductByName(int id){
        return null;
    }
    
    public void addProduct(Product product){
        PRODUCTS.add(product);
    }
    
    public void removeProduct(Product product){
        for (int i = 0; i < PRODUCTS.size(); i++){
            if (PRODUCTS.get(i).equals(product)){
                PRODUCTS.remove(i);
                break;
            }
        }
    }
}
