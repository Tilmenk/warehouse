package com.tilmenk.warehouse.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PokemonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void test_getPokemon() throws Exception {
        //GIVEN
        RequestBuilder request = MockMvcRequestBuilders.get("/api/pokemon");
        //WHEN
        MvcResult result = mvc.perform(request).andReturn();
        //THEN
        assertEquals("[{\"name\":\"pikachu\",\"type1\":\"Electric\"," +
                "\"type2\":\"none\",\"health\":60,\"attack\":45," +
                "\"defense\":49,\"attack_sp\":65,\"defense_sp\":65," +
                "\"speed\":45,\"legendary\":false,\"costs\":54}," + "{\"name" + "\":\"bulbasaur\",\"type1\":\"Grass\"," + "\"type2\":\"Poison" + "\",\"health\":45,\"attack\":49," + "\"defense\":49," + "\"attack_sp\":65,\"defense_sp\":65," + "\"speed\":45," + "\"legendary\":false,\"costs\":53}]", result.getResponse().getContentAsString());
    }

}
