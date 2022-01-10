/*
 * Copyright (c) 2022. Evgeniy Buylin
 */

package en.builin.qna.questions;

import java.util.List;

public interface QuestionsService {

    void addQuestion(Question question);

    List<Question> findQuestionsByPage(int pageNumber);

    List<Question> findQuestionsByAll();

    String getQuestionUrlName(Question question);
}
