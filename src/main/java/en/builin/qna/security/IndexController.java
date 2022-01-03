package en.builin.qna.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pcs.tasktracker.tasks.TasksService;
import ru.pcs.tasktracker.users.User;
import ru.pcs.tasktracker.users.UsersService;

/**
 * @author Evgeniy Builin (en.builin@gmail.com)
 * Created on 24.11.2021 in project task-tracker
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor()
public class IndexController {

    private final UsersService usersService;
    private final TasksService tasksService;

    @GetMapping
    public String getIndexPage(Authentication authentication, Model model) {
        User currentUser = usersService.getUserByEmail(authentication.getName());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("tasks", tasksService.getCurrentTasksByAssignee(currentUser));
        return "index";
    }
}