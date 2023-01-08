package shadow.dictionary.model;

public class Word {

    private final String value;
    private final String translation;

    public Word(String value, String translation) {
        this.value = value;
        this.translation = translation;
    }

    public String getValue() {
        return value;
    }

    public String getTranslation() {
        return translation;
    }
}
