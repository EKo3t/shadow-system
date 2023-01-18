package shadow.dictionary.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import shadow.dictionary.model.Language;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Word {

    @Id
    private String id;
    @Indexed(name = "word_value_unique_index", unique = true)
    private String value;
    private Language language;
}
