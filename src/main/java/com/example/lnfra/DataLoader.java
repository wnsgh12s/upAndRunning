package com.example.lnfra;

import com.example.domain.model.Coffee;
import com.example.domain.repository.CoffeesRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
    private final CoffeesRepository coffeesRepository;

    public DataLoader(CoffeesRepository coffeesRepository) {
        this.coffeesRepository = coffeesRepository;
    }

    @PostConstruct
    private void loadData() {
        coffeesRepository.saveAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas")
        ));

    }
}
