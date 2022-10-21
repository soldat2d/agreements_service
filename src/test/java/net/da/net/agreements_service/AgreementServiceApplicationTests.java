package net.da.net.agreements_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.da.net.agreements_service.controller.AgreementController;
import net.da.net.agreements_service.entity.Agreement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//тесты приведены для примера, не полное покрытие
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AgreementServiceApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AgreementController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnAgreement() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/agreements/1", Agreement.class).getClientId())
                .isEqualTo(3231);
    }

    @Test
    public void shouldReturnStatistics() throws Exception {
        this.mockMvc.perform(get("/statistics")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("minAmount\":\"525.19")));
    }

    @Test
    public void shouldSaveUser() throws Exception {
        Agreement agreement = new Agreement(9876, 1234, "777777.33", new Date(107, Calendar.JULY, 10));
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(post("/agreements").contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(agreement)))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("\"agreementId\":6")));
    }
}
