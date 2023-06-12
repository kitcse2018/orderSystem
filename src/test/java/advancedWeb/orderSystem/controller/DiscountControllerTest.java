package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.DiscountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DiscountControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mvc;

    private static final String BASE_URL = "/discount";

    @Test
    @DisplayName("할인 설정")
    void updateDiscount_Normal() throws Exception {
        //given
        Boolean isRate = true;
        Integer discountPrice = 1000;

        //when
        DiscountDTO discountDTO = new DiscountDTO();
        discountDTO.setIsRate(isRate);
        discountDTO.setDiscountPrice(discountPrice);

        //then
        mvc.perform(put(BASE_URL + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(discountDTO))
        ).andExpect(status().isOk());
    }
}