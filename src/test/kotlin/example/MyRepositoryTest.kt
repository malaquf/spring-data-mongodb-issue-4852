package example

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.reactor.awaitSingleOrNull
import kotlinx.coroutines.test.runTest
import org.example.Application
import org.example.model.MyDocument
import org.example.repository.MyRepository
import org.example.service.MyService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID

@SpringBootTest(classes = [Application::class])
class MyRepositoryTest(
	@Autowired private val myService: MyService,
	@Autowired private val myRepository: MyRepository
) {

	private val doc = MyDocument(UUID.randomUUID().toString(), "Hello")

	@BeforeEach
	fun setUp() {
		myRepository.insert(doc).block()
	}

	@Test
	fun test() = runTest {
		val result = myService.findMeIfYouCan(listOf(doc.id)).awaitSingleOrNull()
		result shouldBe listOf(doc)
	}
}