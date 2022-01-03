package en.builin.qna.security;

import en.builin.qna.users.UserSignUpDto;

public interface SignUpService {

    void signUp(UserSignUpDto dto);
}
