/*
 * Copyright (c) 2022. Evgeniy Buylin
 */

package en.builin.qna.questions;

import en.builin.qna.security.config.UserDetailsImpl;
import en.builin.qna.topics.TopicDto;
import en.builin.qna.topics.TopicsService;
import en.builin.qna.utlis.ModelMapperUtils;
import en.builin.qna.utlis.WebUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class QuestionsController {

    private final QuestionsService questionsService;
    private final TopicsService topicsService;

    @PostMapping(WebUtils.URL_QUESTION_PAGE)
    public String addQuestion(Authentication authentication,
                              @Valid QuestionRegistrationDto questionRegistrationDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("topicsDto", ModelMapperUtils.mapAll(topicsService.getTopics(), TopicDto.class));
            return "add-question";
        }

        Question question = ModelMapperUtils.map(questionRegistrationDto, Question.class);
        question.setAuthor(((UserDetailsImpl) authentication.getPrincipal()).getUser());
        questionsService.addQuestion(question);

        return "redirect:" + WebUtils.URL_QUESTION_PAGE + "/" + questionsService.getQuestionUrlName(question);
    }

    @GetMapping(WebUtils.URL_ADD_QUESTION)
    public String showAddQuestionPage(Model model) {

        model.addAttribute("questionRegistrationDto", new QuestionRegistrationDto());
        model.addAttribute("topicsDto", ModelMapperUtils.mapAll(topicsService.getTopics(), TopicDto.class));
        return "add-question";
    }

    @GetMapping(WebUtils.URL_QUESTIONS)
    public String showQuestionsPage(@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model) {

        model.addAttribute("topicsDto", ModelMapperUtils.mapAll(topicsService.getTopics(), TopicDto.class));
        model.addAttribute("questionsDto",
                ModelMapperUtils.mapAll(questionsService.findQuestionsByPage(pageNumber), QuestionDto.class));
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageTotal", questionsService.getPagesTotalCount());

        return "questions";
    }
}
