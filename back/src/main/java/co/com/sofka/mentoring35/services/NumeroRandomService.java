package co.com.sofka.mentoring35.services;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.mentoring35.models.NumeroRandomDTO;
import co.com.sofka.mentoring35.models.NumeroRandomModel;
import co.com.sofka.mentoring35.repositories.RandomIntegerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NumeroRandomService {

    private RandomIntegerRepository randomIntegerRepository;

    @Autowired
    public NumeroRandomService(RandomIntegerRepository randomIntegerRepository) {
        this.randomIntegerRepository = randomIntegerRepository;
    }
    
    public Mono<NumeroRandomModel> post(NumeroRandomDTO randomInteger) {
        Integer initialNumber = randomInteger.getInitialNumber();
        Integer finalNumber = randomInteger.getFinalNumber();
        Integer amount = randomInteger.getAmount();

        return Mono.just(new NumeroRandomModel()).map(entity -> {
            entity.setInitialNumber(initialNumber);
            entity.setFinalNumber(finalNumber);
            entity.setAmount(amount);
            return entity;
        }).map(entity -> {
            IntStream stream = IntStream.generate(() -> (int)(Math.random() * (finalNumber - initialNumber + 1) + initialNumber));
            int[] numbersList;
            numbersList = stream.limit(amount).toArray();
            entity.setNumbersList(numbersList);
            return entity;
        }).flatMap(randomIntegerRepository::save);
    }

    public Flux<NumeroRandomModel> get() {
        return randomIntegerRepository.findAll();
    }

}
