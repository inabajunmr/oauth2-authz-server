package work.inabajun.authzserver.doma.user

import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserDaoTest {

    @Autowired
    lateinit var sut: UserDao

    @Test
    fun test() {
        val id = UUID.randomUUID().toString()
        sut.insert(UserEntity(id))
        val actual = sut.findById(id)
        assertThat(actual.get().id).isEqualTo(id)
    }
}
