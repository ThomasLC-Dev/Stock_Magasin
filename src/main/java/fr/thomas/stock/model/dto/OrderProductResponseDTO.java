package fr.thomas.stock.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductResponseDTO {

    private Integer quantity;

    private ProductDTO product;
}
