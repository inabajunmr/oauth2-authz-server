package work.inabajun.authzserver.domain.user

import java.lang.RuntimeException

class PasswordMismatchException(message: String) : RuntimeException(message)
