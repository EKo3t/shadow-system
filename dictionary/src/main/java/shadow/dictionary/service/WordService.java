package shadow.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import shadow.dictionary.api.model.Word;
import shadow.dictionary.persistence.converter.ToWordConverter;
import shadow.dictionary.persistence.repository.WordRepository;

@Service
public class WordService {

    private WordRepository repository;

    @Autowired
    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> save(Word word) {
        return repository.save(ToWordConverter.convert(word)).then();
    }
}
