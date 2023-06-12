package advancedWeb.orderSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

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
    void createOrder_Normal() {
        //given

        //when

        //then
    }

    @Test
    @DisplayName("주문 접수")
    void receiptOrder_Normal() {
        //given

        //when

        //then
    }

    @Test
    @DisplayName("주문 배달 완료")
    void completeOrder_Normal() {
        //given

        //when

        //then
    }
}