package work.inabajun.authzserver.doma.user

import org.seasar.doma.Entity
import org.seasar.doma.Table

@Table(name = "user")
@Entity(immutable = true)
class UserEntity(val id: String)
