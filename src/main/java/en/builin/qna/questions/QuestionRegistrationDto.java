package en.builin.qna.questions;

import en.builin.qna.topics.Topic;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class QuestionRegistrationDto {

    @NotBlank
    // TODO Не работает валидатор
    private Topic topic;
    @NotBlank
    private String text;
}
