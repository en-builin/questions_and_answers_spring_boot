package en.builin.qna.questions;

import en.builin.qna.categories.Category;
import en.builin.qna.users.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class QuestionDto {

    private Long id;
    private User author;
    private Category category;
    private String text;
    private String source;
    private Instant createdAt;
    private Instant updatedAt;

    //TODO https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
    //TODO https://www.baeldung.com/java-modelmapper
}
