package advancedWeb.orderSystem.util;

import advancedWeb.orderSystem.domain.*;
import advancedWeb.orderSystem.dto.*;

public class EntityConverter {
    public static Menu toMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setId(menuDTO.getId());
        menu.setName(menuDTO.getName());
        menu.setPrice(menuDTO.getPrice());
        menu.setQuantity(menuDTO.getQuantity());
        menu.setPictureUrl(menuDTO.getPictureUrl());
        menu.setInfo(menuDTO.getInfo());
        menu.setType(menuDTO.getType());
        menu.setDiscountId(menuDTO.getDiscountId());

        return menu;
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
        member.setPassword(memberDTO.getPassword());
        member.setName(memberDTO.getName());
        member.setRoleType(memberDTO.getRoleType());

        return member;
    }

    public static OrderItem toOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        Order order = new Order();
        Menu menu = new Menu();

        order.setId(orderItemDTO.getOrderId());
        menu.setId(orderItemDTO.getMenuId());

        orderItem.setId(orderItemDTO.getId());
        orderItem.setOrder(order);
        orderItem.setMenu(menu);
        orderItem.setAmount(orderItemDTO.getAmount());

        return orderItem;
    }
}
