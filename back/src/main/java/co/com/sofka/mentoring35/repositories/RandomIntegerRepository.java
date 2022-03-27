package co.com.sofka.mentoring35.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import co.com.sofka.mentoring35.models.NumeroRandomModel;

public interface RandomIntegerRepository extends ReactiveCrudRepository<NumeroRandomModel, String> {
    
}
