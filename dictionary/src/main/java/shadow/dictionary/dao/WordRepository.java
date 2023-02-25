package shadow.dictionary.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import shadow.dictionary.model.persistence.Word;

@Repository
public interface WordRepository extends MongoRepository<Word, String> {
}
