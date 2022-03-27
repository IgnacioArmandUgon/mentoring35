package co.com.sofka.mentoring35.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.mentoring35.models.NumeroRandomDTO;
import co.com.sofka.mentoring35.models.NumeroRandomModel;
import co.com.sofka.mentoring35.services.NumeroRandomService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/random")
public class NumeroRandomController {

    private NumeroRandomService randomIntegerService;

    @Autowired
    public NumeroRandomController(NumeroRandomService randomIntegerService) {
        this.randomIntegerService = randomIntegerService;
    }

    @PostMapping
    public Mono<NumeroRandomModel> post(@RequestBody NumeroRandomDTO randomInteger) {
        return randomIntegerService.post(randomInteger);
        
    }

    @GetMapping
    public Flux<NumeroRandomModel> get() {
        return randomIntegerService.get();
    }
    
}
