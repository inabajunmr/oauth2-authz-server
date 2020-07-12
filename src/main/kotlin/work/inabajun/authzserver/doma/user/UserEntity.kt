package work.inabajun.authzserver.doma.user

import org.seasar.doma.Entity
import org.seasar.doma.Table
import work.inabajun.authzserver.domain.user.User

/**
 * User object for persistence by Doma
 */
@Table(name = "user")
@Entity(immutable = true)
class UserEntity(val id: String, val hashedPassword: String) {

    fun toUser(): User {
        return User(id)
    }
}
