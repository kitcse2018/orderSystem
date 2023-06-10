package advancedWeb.orderSystem.util;

import advancedWeb.orderSystem.domain.*;
import advancedWeb.orderSystem.dto.*;

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

    public static Delivery toDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();

        delivery.setId(deliveryDTO.getId());
        delivery.setOrder(deliveryDTO.getOrder());
        delivery.setStatus(deliveryDTO.getStatus());

        return delivery;
    }

    public static Shop toShop(ShopDTO shopDTO) {
        Shop shop = new Shop();

        shop.setId(shopDTO.getId());
        shop.setName(shopDTO.getName());
        shop.setAddress(shopDTO.getAddress());
        shop.setNumber(shopDTO.getNumber());
        shop.setOpenTime(shopDTO.getOpenTime());
        shop.setCloseTime(shopDTO.getCloseTime());

        return shop;
    }

    public static Member toMember(MemberDTO memberDTO) {
        Member member = new Member();

        member.setId(memberDTO.getId());
        member.setName(memberDTO.getName());
        member.setRoleType(memberDTO.getRoleType());

        return member;
    }
}
