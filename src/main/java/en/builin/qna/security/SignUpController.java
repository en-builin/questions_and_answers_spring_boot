package en.builin.qna.security;

import en.builin.qna.users.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor()
@Controller
@RequestMapping("/registration")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getSignUpPage(Authentication authentication, Model model) {

        if (authentication != null) {
            //TODO переходить на стрницу профиля
            return "redirect:/";
        }

        model.addAttribute("signUpForm", new UserSignUpDto());
        return "sign-up";
    }

    @PostMapping
    public String signUp(@Valid @ModelAttribute("signUpForm") UserSignUpDto form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "sign-up";
        }

        signUpService.signUp(form);
        return "redirect:/";
    }

}
