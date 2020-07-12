package work.inabajun.authzserver.doma.user

import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DuplicateKeyException

@SpringBootTest
class UserDaoTest {

    @Autowired
    lateinit var sut: UserDao

    @Test
    fun insertAndSelectById() {
        // setup
        val id = UUID.randomUUID().toString()

        // exercise
        sut.insert(UserEntity(id, "test"))
        val actual = sut.selectById(id)

        // verify
        assertThat(actual.get().id).isEqualTo(id)
        assertThat(actual.get().hashedPassword).isEqualTo("test")
    }

    @Test
    fun insertMultipleSameId() {
        // setup
        val id = UUID.randomUUID().toString()
        sut.insert(UserEntity(id, "test"))

        // exercise
        val actual = catchThrowable { sut.insert(UserEntity(id, "test")) }

        // verify
        assertThat(actual).isInstanceOf(DuplicateKeyException::class.java)
    }
}
