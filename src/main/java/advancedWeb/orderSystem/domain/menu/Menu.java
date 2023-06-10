package advancedWeb.orderSystem.domain.menu;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorColumn(name = "M_TYPE")
public abstract class Menu {
    @Id
    @GeneratedValue
    @Column(name = "MENU_ID")
    private Long id;

    // 메뉴 이름
    private String name;

    // 메뉴 가격
    private int price;

    // 메뉴 판매 수량
    private int quantity;

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    // exception package에 NotEnoughStockException.java 파일을 만들어야 됨
    /*public void removeQuantity(int quantity) {
        int currentQuantity = this.quantity - quantity;
        if(currentQuantity < 0)
            throw new NotEnoughStockException(this.quantity, quantity);
        this.quantity = currentQuantity;
    }*/
}
