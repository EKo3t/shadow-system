package shadow.dictionary.persistence.converter;

import shadow.dictionary.model.Language;
import shadow.dictionary.persistence.model.Word;

public final class ToWordConverter {

    public static Word convert(shadow.dictionary.api.model.Word apiWord) {
        return new Word(null, apiWord.getValue(), Language.valueOf(apiWord.getLanguage()));
    }
}
