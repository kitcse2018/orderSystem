package advancedWeb.orderSystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MenuDTO {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String pictureUrl;
    private String info;
    private String type;
}
