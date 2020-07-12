package work.inabajun.authzserver.view.user.ui

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController(
//        val authManager : AuthenticationManager
) {

    @GetMapping("/login")
    fun getLogin(): String {
        return "login"
    }

//    @PostMapping("/login2")
//    fun doLogin(@RequestParam("username") username:String, @RequestParam("password")  password:String) : String {
//        val authRequest = UsernamePasswordAuthenticationToken(
//                username, password)
//        authManager.authenticate(authRequest)
// //        sessionStrategy.onAuthentication(authResult, request, response)
//
//        return "root"
//    }
}
