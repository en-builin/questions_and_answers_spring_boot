/*
 * Copyright (c) 2022. Evgeniy Buylin
 */

package en.builin.qna.questions;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsRepository questionsRepository;
    private static final int PAGE_SIZE = 10;

    @Override
    public void addQuestion(Question question) {
        questionsRepository.save(question);
    }

    @Override
    public List<Question> findQuestionsByPage(int pageNumber) {
        return questionsRepository.findByDeletedIsNullOrderByCreatedAtDesc(
                Pageable.ofSize(PAGE_SIZE).withPage(pageNumber - 1));
    }

    @Override
    public List<Question> findQuestionsByAll() {
        return questionsRepository.findByDeletedIsNull(Sort.by(Sort.Order.desc("createdAt")));
    }

    @Override
    public String getQuestionUrlName(Question question) {
        // TODO привести к транслитерации https://ru.stackoverflow.com/questions/633355/
        return question.getId().toString();
    }
}
