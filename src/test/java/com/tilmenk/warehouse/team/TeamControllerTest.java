package com.tilmenk.warehouse.team;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void test_getTeams() throws Exception {
        //GIVEN
        RequestBuilder request = MockMvcRequestBuilders.get("/api/team");
        //WHEN
        MvcResult result = mvc.perform(request).andReturn();
        //THEN
        assertEquals("[{\"id\":1,\"pokemon_0\":{\"name\":\"pikachu\"," +
                "\"type1\":\"Electric\",\"type2\":\"none\",\"health\":60," +
                "\"attack\":45,\"defense\":49,\"attack_sp\":65," +
                "\"defense_sp\":65,\"speed\":45,\"legendary\":false," +
                "\"costs\":54},\"pokemon_1\":{\"name\":\"pikachu\"," +
                "\"type1\":\"Electric\",\"type2\":\"none\",\"health\":60," +
                "\"attack\":45,\"defense\":49,\"attack_sp\":65," +
                "\"defense_sp\":65,\"speed\":45,\"legendary\":false," +
                "\"costs\":54},\"pokemon_2\":{\"name\":\"pikachu\"," +
                "\"type1\":\"Electric\",\"type2\":\"none\",\"health\":60," +
                "\"attack\":45,\"defense\":49,\"attack_sp\":65," +
                "\"defense_sp\":65,\"speed\":45,\"legendary\":false," +
                "\"costs\":54},\"pokemon_3\":{\"name\":\"pikachu\"," +
                "\"type1\":\"Electric\",\"type2\":\"none\",\"health\":60," +
                "\"attack\":45,\"defense\":49,\"attack_sp\":65," +
                "\"defense_sp\":65,\"speed\":45,\"legendary\":false," +
                "\"costs\":54},\"pokemon_4\":{\"name\":\"pikachu\"," +
                "\"type1\":\"Electric\",\"type2\":\"none\",\"health\":60," +
                "\"attack\":45,\"defense\":49,\"attack_sp\":65," +
                "\"defense_sp\":65,\"speed\":45,\"legendary\":false," +
                "\"costs\":54},\"pokemon_5\":{\"name\":\"pikachu\"," +
                "\"type1\":\"Electric\",\"type2\":\"none\",\"health\":60," +
                "\"attack\":45,\"defense\":49,\"attack_sp\":65," +
                "\"defense_sp\":65,\"speed\":45,\"legendary\":false," +
                "\"costs\":54}}]", result.getResponse().getContentAsString());
    }

}
