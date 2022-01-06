/*
 * Copyright (c) 2022. Evgeniy Buylin
 */

package en.builin.qna.questions;

import en.builin.qna.utlis.ModelMapperUtils;
import en.builin.qna.utlis.WebUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class QuestionsController {

    private final QuestionsService questionsService;

    @PostMapping(WebUtils.URL_QUESTIONS)
    public String addQuestion(@Valid QuestionRegistrationDto questionRegistrationDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-question";
        }

        Question question = ModelMapperUtils.map(questionRegistrationDto, Question.class);
        questionsService.addQuestion(question);

        return "redirect:" + WebUtils.URL_QUESTIONS + "/" + question.getId();
    }

    @GetMapping(WebUtils.URL_ADD_QUESTION)
    public String showAddQuestion(Model model) {

        model.addAttribute("questionRegistrationDto", new QuestionRegistrationDto());
        return "add-question";
    }

}
