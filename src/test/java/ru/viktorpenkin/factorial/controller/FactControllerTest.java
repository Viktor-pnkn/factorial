package ru.viktorpenkin.factorial.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.viktorpenkin.factorial.dto.NumDTO;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FactControllerTest {

    private RestTemplate template = new RestTemplate();
    private Random r = new Random();

    @Test
    public void testGetFact() {
        int i = r.nextInt(10);
        ResponseEntity<NumDTO> forEntity = template.getForEntity("http://localhost:8081/factorial/" + i,
                NumDTO.class);
        Long actual = forEntity.getBody().getValue();

        Long expected = 1L;
        for (Long j = 1L; j < i + 1; j++) {
            expected *= j;
        }

        assertEquals(expected, actual);
    }
}
