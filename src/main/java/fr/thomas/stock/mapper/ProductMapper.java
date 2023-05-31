package fr.thomas.stock.mapper;

import fr.thomas.stock.model.Product;
import fr.thomas.stock.model.dto.ProductDTO;

import java.util.List;

public class ProductMapper {

    public static List<ProductDTO> productListToDto(List<Product> products){
        return products.stream().map(ProductMapper::productToDto).toList();
    }
    public static ProductDTO productToDto(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getQuantity(), product.getPrice());
    }
}
