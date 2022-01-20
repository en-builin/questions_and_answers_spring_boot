/*
 * Copyright (c) 2022. Evgeniy Buylin
 */

package en.builin.qna.questions;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionsMapper {

    private final ModelMapper modelMapper;

    public QuestionsMapper() {
        modelMapper = new ModelMapper();
    }

    public QuestionDto toDto(Question question) {
        return modelMapper.map(question, QuestionDto.class);
    }

    public QuestionDto toDto(Question question, QuestionDto questionDto) {
        modelMapper.map(question, questionDto);
        return questionDto;
    }

    public List<QuestionDto> toDto(List<Question> questions) {
        return questions.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Question fromDto(QuestionDto questionDto) {
        return modelMapper.map(questionDto, Question.class);
    }

    public Question fromDto(QuestionDto questionDto, Question question) {
        modelMapper.map(questionDto, question);
        return question;
    }

    public List<Question> fromDto(List<QuestionDto> questions) {
        return questions.stream().map(this::fromDto).collect(Collectors.toList());
    }

    public Question fromDto(QuestionCreateDto questionCreateDto) {
        return modelMapper.map(questionCreateDto, Question.class);
    }

}
