package fr.thomas.stock.service;

import fr.thomas.stock.model.Product;
import fr.thomas.stock.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
    public Product getProduct(Long productId);
    public void saveProduct(ProductDTO productDTO);
    public void updateProduct(Long productId, ProductDTO productDTO);
    public void deleteProduct(Long productId);
}
