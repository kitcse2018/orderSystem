package advancedWeb.orderSystem.util;

import advancedWeb.orderSystem.domain.Discount;
import advancedWeb.orderSystem.domain.Menu;
import advancedWeb.orderSystem.dto.DiscountDTO;
import advancedWeb.orderSystem.dto.MenuDTO;

public class EntityConverter {
    public static Menu toMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setId(menuDTO.getId());
        menu.setName(menuDTO.getName());
        menu.setPrice(menuDTO.getPrice());
        menu.setQuantity(menu.getQuantity());
        menu.setPictureUrl(menuDTO.getPictureUrl());
        menu.setInfo(menuDTO.getInfo());
        menu.setType(menuDTO.getType());

        return menu;
    }

    public static Discount toDiscount(DiscountDTO discountDTO) {
        Discount discount = new Discount();

        discount.setId(discount.getId());
        discount.setIsRate(discountDTO.isRate());
        discount.setDiscountPrice(discountDTO.getDiscountPrice());

        return discount;
    }
}
