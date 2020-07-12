package work.inabajun.authzserver.domain.user

import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Service
import work.inabajun.authzserver.doma.user.UserDao
import work.inabajun.authzserver.doma.user.UserEntity

@Service
class UserService {

    lateinit var dao: UserDao

    /**
     * Signup
     *
     * @throws UserAlreadyExistException if same id user already exists
     */
    fun signup(id: String, lawPassword: String): User {
        try {
            val result = dao.insert(UserEntity(id, PasswordHashGenerator.hash(lawPassword)))
            return result.entity.toUser()
        } catch (e: DuplicateKeyException) {
            throw UserAlreadyExistException("User:$id is duplicated.", e)
        }
    }

    /**
     * If login failed, throw exception
     *
     * @throws UserNotFoundException user not found
     */
    fun loginByPassword(id: String, lawPassword: String) {
        // find existed user
        val hashedPassword = dao.selectById(id).orElseThrow { UserNotFoundException("User:$id is not found.") }.hashedPassword
        if (!PasswordHashGenerator.equalsLawPasswordAndHash(lawPassword, hashedPassword)) {
            throw PasswordMismatchException("Password is mismatched.")
        }
    }
}
