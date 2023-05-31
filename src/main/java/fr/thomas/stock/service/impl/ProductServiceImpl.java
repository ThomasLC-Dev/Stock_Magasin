package fr.thomas.stock.service.impl;

import fr.thomas.stock.exception.ElementNotFoundException;
import fr.thomas.stock.model.Product;
import fr.thomas.stock.model.dto.ProductDTO;
import fr.thomas.stock.repository.ProductRepository;
import fr.thomas.stock.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ElementNotFoundException("Product not found !"));
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long productId, ProductDTO productDTO) {
        Product product = this.getProduct(productId);
        product.setName((productDTO.getName() == null) ? product.getName() : productDTO.getName());
        product.setQuantity((productDTO.getQuantity() == null) ? product.getQuantity() : productDTO.getQuantity());
        product.setPrice((productDTO.getPrice() == null) ? product.getPrice() : productDTO.getPrice());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        this.getProduct(productId);
        productRepository.deleteById(productId);
    }
}
