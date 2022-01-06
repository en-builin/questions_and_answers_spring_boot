package en.builin.qna;

import en.builin.qna.users.UsersService;
import en.builin.qna.utlis.WebUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(WebUtils.URL_INDEX)
@RequiredArgsConstructor()
public class IndexController {

    private final UsersService usersService;

    @GetMapping
    public String getIndexPage(Authentication authentication, Model model) {

//        if (authentication.isAuthenticated()) {
//            UserDto userDto = ModelMapperUtils.map(usersService.getUserByEmail(authentication.getName()), UserDto.class);
//            model.addAttribute("userDto", userDto);
//        }

        return "index";
    }
}