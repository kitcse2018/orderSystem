package advancedWeb.orderSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private String delivery;
    private Integer totalPrice;
    private Long orderMemberId;
    private Boolean isContainMain;
    private LocalDateTime creationTime;
    private List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
}
