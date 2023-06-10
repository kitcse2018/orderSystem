package advancedWeb.orderSystem.dto;

import lombok.Data;

@Data
public class DiscountDTO {
    private Long id;
    private boolean isRate;
    private int discountPrice;
}
