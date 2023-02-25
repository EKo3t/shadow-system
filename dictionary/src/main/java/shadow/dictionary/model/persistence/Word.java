package shadow.dictionary.model.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import shadow.dictionary.model.Language;

@Document("words")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Word {

    @Id
    private String id;
    @Indexed(unique = true)
    private String value;
    private Language lan;
}
