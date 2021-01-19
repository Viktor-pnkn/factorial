package ru.viktorpenkin.factorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.viktorpenkin.factorial.dto.CommonDTO;
import ru.viktorpenkin.factorial.dto.NumDTO;

@RestController
@RequestMapping("factorial")
public class FactController {

    @GetMapping("/{val}")
    public CommonDTO getFact(@PathVariable Long val) {
        return new CommonDTO("FACT", factorial(val));
    }

    private Long factorial(Long n) {
        Long f = 1L;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
