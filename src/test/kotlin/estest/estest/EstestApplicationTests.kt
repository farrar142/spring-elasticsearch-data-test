package estest.estest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.math.ln
import kotlin.test.BeforeTest

@SpringBootTest
class EstestApplicationTests {
	@Autowired lateinit var logService: LogService
	@Autowired lateinit var logRepository: LogRepository
	@BeforeTest
	fun initialize(){
		logRepository.deleteAll()
	}
	@Test
	fun contextLoads() {
	}

	@Test
	fun create(){
		val log = logService.create("test")
		println(log.id)
		println(logRepository.findAll())
	}

}
