package advancedWeb.orderSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class MenuForm {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Range(min=1000,max=1000000)
    private Integer price;
    private Integer stockQuantity;
}