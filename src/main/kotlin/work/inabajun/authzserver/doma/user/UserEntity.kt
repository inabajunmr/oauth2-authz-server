package work.inabajun.authzserver.doma.user

import org.seasar.doma.Entity
import org.seasar.doma.Table

/**
 * User object for persistence by Doma
 */
@Table(name = "user")
@Entity(immutable = true)
class UserEntity(val id: String, val hashedPassword: String)
