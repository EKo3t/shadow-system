package shadow.dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shadow.dictionary.model.Language;
import shadow.dictionary.model.Word;
import shadow.dictionary.model.api.AddWordRequest;
import shadow.dictionary.service.DictionaryService;

@Controller
public class WordController {

    private final DictionaryService dictionaryService;

    @Autowired
    public WordController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "dictionary/word/add")
    public ResponseEntity<Void> add(@RequestBody AddWordRequest request) {
        Word word = new Word(request.getValue(), Language.valueOf(request.getLan()));
        dictionaryService.addWord(word);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "dictionary/word")
    public ResponseEntity<String> delete() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
