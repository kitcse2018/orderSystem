package advancedWeb.orderSystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MenuDTO {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
    private String pictureUrl;
    private String info;
    private String type;
    private Integer discountId;
}
