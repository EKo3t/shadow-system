package shadow.dictionary.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import shadow.dictionary.persistence.model.Word;

@Repository
public interface WordRepository extends ReactiveMongoRepository<Word, String> {
}
