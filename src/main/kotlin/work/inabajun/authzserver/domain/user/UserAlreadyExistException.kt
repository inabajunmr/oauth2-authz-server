package work.inabajun.authzserver.domain.user

class UserAlreadyExistException(message: String, cause: Throwable) : RuntimeException(message, cause)
