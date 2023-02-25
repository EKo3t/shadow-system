package shadow.dictionary.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Word {

    private final String id;
    private final String value;
    private final Language lan;

    public Word(String value, Language lan) {
        this.id = null;
        this.value = value;
        this.lan = lan;
    }
}
