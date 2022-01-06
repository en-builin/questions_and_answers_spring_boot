/*
 * Copyright (c) 2022. Evgeniy Buylin
 */

package en.builin.qna.questions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionRepository questionRepository;

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }
}
