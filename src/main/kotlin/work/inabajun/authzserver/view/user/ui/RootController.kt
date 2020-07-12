package work.inabajun.authzserver.view.user.ui

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RootController {

    @GetMapping("/")
    fun getRoot(): String {
        return "root"
    }
}
