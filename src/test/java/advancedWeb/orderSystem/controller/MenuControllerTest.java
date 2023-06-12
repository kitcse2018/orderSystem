package advancedWeb.orderSystem.controller;

import advancedWeb.orderSystem.dto.MenuDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MenuControllerTest {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mvc;

    private static final String BASE_URL = "/menu";

    @Test
    @DisplayName("메뉴 등록")
    void createMenu_Normal() throws Exception {
        //given
        String name = "햄버거";
        Integer price  = 1;
        Integer quantity = 0;
        String pictureUrl = "asd";
        String info = "설명입니다.";
        String type = "main";

        //when
        MenuDTO menuDTO = new MenuDTO();;
        menuDTO.setName(name);
        menuDTO.setPrice(price);
        menuDTO.setQuantity(quantity);
        menuDTO.setPictureUrl(pictureUrl);
        menuDTO.setInfo(info);
        menuDTO.setType(type);

        //then
        mvc.perform(post(BASE_URL + "/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(menuDTO))
        ).andExpect(status().isOk());

    }

    @Test
    @DisplayName("메뉴 등록 예외 확인")
    void createMenu_Exception() throws Exception {
        //given
        String name = "싸이버거";
        Integer price  = 1;
        Integer quantity = 0;
        String pictureUrl = "asd";
        String info = "설명입니다.";
        String type = "main";

        //when
        MenuDTO menuDTO = new MenuDTO();;
        menuDTO.setName(name);
        menuDTO.setPrice(price);
        menuDTO.setQuantity(quantity);
        menuDTO.setPictureUrl(pictureUrl);
        menuDTO.setInfo(info);
        menuDTO.setType(type);

        //then
        mvc.perform(post(BASE_URL + "/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(menuDTO))
        ).andExpect(status().isOk());

    }

    @Test
    @DisplayName("메뉴 수정")
    void updateMenu_Normal() throws Exception {
        //given
        String name = "싸이버거";
        Integer price  = 1;
        Integer quantity = 0;
        String pictureUrl = "asd";
        String info = "설명입니다.";
        String type = "main";

        //when
        MenuDTO menuDTO = new MenuDTO();;
        menuDTO.setName(name);
        menuDTO.setPrice(price);
        menuDTO.setQuantity(quantity);
        menuDTO.setPictureUrl(pictureUrl);
        menuDTO.setInfo(info);
        menuDTO.setType(type);

        //then
        mvc.perform(put(BASE_URL + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(menuDTO))
        ).andExpect(status().isOk());

    }
}