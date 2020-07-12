package work.inabajun.authzserver.view.user.ui

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun getLogin(): String {
        return "login"
    }
}
