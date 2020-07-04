package work.inabajun.authzserver.doma.user

import java.util.Optional
import org.seasar.doma.Dao
import org.seasar.doma.Insert
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.Result

@Dao
@ConfigAutowireable
interface UserDao {

    @Insert
    fun insert(entity: UserEntity): Result<UserEntity>

    @Select
    fun findById(id: String): Optional<UserEntity>
}
