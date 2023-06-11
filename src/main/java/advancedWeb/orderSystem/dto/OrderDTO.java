package advancedWeb.orderSystem.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Long discountId;
    private String delivery;
    private List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
}
