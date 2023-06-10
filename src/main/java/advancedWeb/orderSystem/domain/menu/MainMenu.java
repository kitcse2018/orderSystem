package advancedWeb.orderSystem.domain.menu;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("M")
public class MainMenu extends Menu{
    // 메뉴 사진
    private String pictureUrl;

    // 메뉴 상세 설명
    private String info;
}
