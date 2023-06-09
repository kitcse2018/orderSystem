package advancedWeb.orderSystem.domain.menu;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("S")
public class SideMenu extends Menu{
}
