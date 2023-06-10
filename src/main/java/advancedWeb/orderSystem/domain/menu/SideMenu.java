package advancedWeb.orderSystem.domain.menu;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("S")
public class SideMenu extends Menu{
}
