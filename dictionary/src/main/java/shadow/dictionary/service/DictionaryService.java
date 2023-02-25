package shadow.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shadow.dictionary.dao.WordRepository;
import shadow.dictionary.model.Word;

@Service
public class DictionaryService {

    private final WordRepository wordRepository;

    @Autowired
    public DictionaryService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public void addWord(Word word) {
        wordRepository.save(
            new shadow.dictionary.model.persistence.Word(
                word.getId(), word.getValue(), word.getLan()
            )
        );
    }
}
