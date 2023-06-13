package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.OrderDTO;
import advancedWeb.orderSystem.dto.OrderItemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mvc;

    private static final String BASE_URL = "/order";

    @Test
    @DisplayName("주문 생성")
    void createOrder_Normal() throws Exception {
        //given
        String delivery = "ORDER";
        Integer totalPrice = 12000;
        Long orderMemberId = 1L;
        Boolean isContainMain = true;

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        OrderItemDTO orderItemDTO1 = new OrderItemDTO();
        orderItemDTO1.setMenuId(1L);
        orderItemDTO1.setOrderId(1L);
        orderItemDTO1.setAmount(3);

        OrderItemDTO orderItemDTO2 = new OrderItemDTO();
        orderItemDTO2.setMenuId(1L);
        orderItemDTO2.setOrderId(1L);
        orderItemDTO2.setAmount(3);

        OrderItemDTO orderItemDTO3 = new OrderItemDTO();
        orderItemDTO3.setMenuId(1L);
        orderItemDTO3.setOrderId(1L);
        orderItemDTO3.setAmount(3);

        orderItemDTOList.add(orderItemDTO1);
        orderItemDTOList.add(orderItemDTO2);
        orderItemDTOList.add(orderItemDTO3);

        //when
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDelivery(delivery);
        orderDTO.setTotalPrice(totalPrice);
        orderDTO.setOrderMemberId(orderMemberId);
        orderDTO.setIsContainMain(isContainMain);
        orderDTO.setOrderItemDTOList(orderItemDTOList);

        //then
        mvc.perform(post(BASE_URL + "/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderDTO))
        ).andExpect(status().isOk());
    }

    @Test
    @DisplayName("주문 생성 시간 예외")
    void createOrder_Time_Exception() throws Exception {
        //given
        String delivery = "ORDER";
        Integer totalPrice = 12000;
        Long orderMemberId = 1L;
        Boolean isContainMain = true;

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        OrderItemDTO orderItemDTO1 = new OrderItemDTO();
        orderItemDTO1.setMenuId(1L);
        orderItemDTO1.setOrderId(2L);
        orderItemDTO1.setAmount(3);

        OrderItemDTO orderItemDTO2 = new OrderItemDTO();
        orderItemDTO2.setMenuId(2L);
        orderItemDTO2.setOrderId(2L);
        orderItemDTO2.setAmount(3);

        OrderItemDTO orderItemDTO3 = new OrderItemDTO();
        orderItemDTO3.setMenuId(3L);
        orderItemDTO3.setOrderId(2L);
        orderItemDTO3.setAmount(3);

        orderItemDTOList.add(orderItemDTO1);
        orderItemDTOList.add(orderItemDTO2);
        orderItemDTOList.add(orderItemDTO3);

        //when
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDelivery(delivery);
        orderDTO.setTotalPrice(totalPrice);
        orderDTO.setOrderMemberId(orderMemberId);
        orderDTO.setIsContainMain(isContainMain);
        orderDTO.setOrderItemDTOList(orderItemDTOList);

        //then
        mvc.perform(post(BASE_URL + "/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderDTO))
        ).andExpect(status().isOk());
    }

    @Test
    @DisplayName("주문 생성 메인 메뉴 없는 예외")
    void createOrder_NotMain_Exception() throws Exception {
        //given
        String delivery = "ORDER";
        Integer totalPrice = 12000;
        Long orderMemberId = 1L;
        Boolean isContainMain = false;

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        OrderItemDTO orderItemDTO1 = new OrderItemDTO();
        orderItemDTO1.setMenuId(1L);
        orderItemDTO1.setOrderId(3L);
        orderItemDTO1.setAmount(3);

        OrderItemDTO orderItemDTO2 = new OrderItemDTO();
        orderItemDTO2.setMenuId(2L);
        orderItemDTO2.setOrderId(3L);
        orderItemDTO2.setAmount(3);

        OrderItemDTO orderItemDTO3 = new OrderItemDTO();
        orderItemDTO3.setMenuId(3L);
        orderItemDTO3.setOrderId(3L);
        orderItemDTO3.setAmount(3);

        orderItemDTOList.add(orderItemDTO1);
        orderItemDTOList.add(orderItemDTO2);
        orderItemDTOList.add(orderItemDTO3);

        //when
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDelivery(delivery);
        orderDTO.setTotalPrice(totalPrice);
        orderDTO.setOrderMemberId(orderMemberId);
        orderDTO.setIsContainMain(isContainMain);
        orderDTO.setOrderItemDTOList(orderItemDTOList);

        //then
        mvc.perform(post(BASE_URL + "/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderDTO))
        ).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("주문 생성 최소 가격 예외")
    void createOrder_LeastPrice_Exception() throws Exception {
        //given
        String delivery = "ORDER";
        Integer totalPrice = 7000;
        Long orderMemberId = 1L;
        Boolean isContainMain = true;

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        OrderItemDTO orderItemDTO1 = new OrderItemDTO();
        orderItemDTO1.setMenuId(1L);
        orderItemDTO1.setOrderId(4L);
        orderItemDTO1.setAmount(3);

        OrderItemDTO orderItemDTO2 = new OrderItemDTO();
        orderItemDTO2.setMenuId(2L);
        orderItemDTO2.setOrderId(4L);
        orderItemDTO2.setAmount(3);

        OrderItemDTO orderItemDTO3 = new OrderItemDTO();
        orderItemDTO3.setMenuId(3L);
        orderItemDTO3.setOrderId(4L);
        orderItemDTO3.setAmount(3);

        orderItemDTOList.add(orderItemDTO1);
        orderItemDTOList.add(orderItemDTO2);
        orderItemDTOList.add(orderItemDTO3);

        //when
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDelivery(delivery);
        orderDTO.setTotalPrice(totalPrice);
        orderDTO.setOrderMemberId(orderMemberId);
        orderDTO.setIsContainMain(isContainMain);
        orderDTO.setOrderItemDTOList(orderItemDTOList);

        //then
        mvc.perform(post(BASE_URL + "/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderDTO))
        ).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("주문 접수")
    void receiptOrder_Normal() throws Exception {
        //given
        String delivery = "DELIVERY";
        Long orderId  = 28L; // Change When Test

        //when

        //then
        mvc.perform(put(BASE_URL + "/accept")
                .param("orderId", String.valueOf(orderId))
                .param("delivery", delivery)
        ).andExpect(status().isOk());
    }

    @Test
    @DisplayName("주문 배달 완료")
    void completeOrder_Normal() throws Exception {
        //given
        String delivery = "COMPLETE";
        Long orderId  = 28L; //Change When Test

        //when

        //then
        mvc.perform(put(BASE_URL + "/update")
                .param("orderId", String.valueOf(orderId))
                .param("orderDelivery", delivery)
        ).andExpect(status().isOk());
    }
}