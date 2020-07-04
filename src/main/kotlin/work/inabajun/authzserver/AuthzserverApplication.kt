package work.inabajun.authzserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthzserverApplication

fun main(args: Array<String>) {
    runApplication<AuthzserverApplication>(*args)
}
