package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.controller.BeerController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("postgresql")
public class PostgresqlTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BeerRepository beerRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:16");


//    @DynamicPropertySource
//    static void postgresProperties(DynamicPropertyRegistry registry){
//        registry.add("spring.datasource.username",postgreSQLContainer::getUsername);
//        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
//        registry.add("spring.datasource.url",postgreSQLContainer::getJdbcUrl);
//    }

    @Test
    public void testDeleteByID() throws Exception{
        UUID testId = beerRepository.findAll().getFirst().getId();

        mockMvc.perform(
                delete(BeerController.BEER_PATH+"/"+testId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent());
        beerRepository.flush();
        assertThat(beerRepository.findById(testId)).isEmpty();
    }
}
