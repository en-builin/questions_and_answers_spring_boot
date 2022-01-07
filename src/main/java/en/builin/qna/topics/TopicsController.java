/*
 * Copyright (c) 2022. Evgeniy Buylin
 */

package en.builin.qna.topics;

import en.builin.qna.utlis.ModelMapperUtils;
import en.builin.qna.utlis.WebUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(WebUtils.URL_TOPICS)
public class TopicsController {

    private final TopicsService topicsService;

    @GetMapping
    public String getTopicsPage(Model model) {
        model.addAttribute("topicsDto",
                ModelMapperUtils.mapAll(topicsService.getTopics(), TopicDto.class));
        return "topics";
    }

    @GetMapping("/del")
    public String deleteTopic(@RequestParam("id") Long id) {
        topicsService.deleteTopic(topicsService.getTopicById(id));
        return "redirect:" + WebUtils.URL_TOPICS;
    }

    @PostMapping
    public String saveTopic(TopicDto topicDto) {
        if (topicDto.getId() != null) {
            Topic topic = topicsService.getTopicById(topicDto.getId());
            topic.setName(topicDto.getName());
            topicsService.saveTopic(topic);
        } else {
            topicsService.saveTopic(ModelMapperUtils.map(topicDto, Topic.class));
        }
        return "redirect:" + WebUtils.URL_TOPICS;
    }
}
