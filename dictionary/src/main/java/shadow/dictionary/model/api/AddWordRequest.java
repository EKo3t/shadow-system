package shadow.dictionary.model.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AddWordRequest {

    private final String value;
    private final String lan;

    @JsonCreator
    public AddWordRequest(@JsonProperty("value") String value, @JsonProperty("lan") String lan) {
        this.value = value;
        this.lan = lan;
    }
}
