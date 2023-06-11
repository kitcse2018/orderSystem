package advancedWeb.orderSystem.dto;

import lombok.Data;

@Data
public class DiscountDTO {
    private Long id;
    private Boolean isRate;
    private Integer discountPrice;
}
