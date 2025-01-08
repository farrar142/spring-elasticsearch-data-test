package estest.estest

import co.elastic.clients.elasticsearch.ml.Page
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.PageRequest
import kotlin.math.ln
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

@SpringBootTest
class EstestApplicationTests {
	@Autowired lateinit var logService: LogService
	@Autowired lateinit var logRepository: LogRepository

	@BeforeEach
	fun initialize(){
		logRepository.deleteAll()
	}
	@Test
	fun contextLoads() {
	}

	@Test
	fun create(){
		assertEquals(logRepository.findAll().toList().isEmpty(),true)
		logService.create("test")
		assertEquals(logRepository.findAll().toList().size,1)
	}
	@Test
	fun read(){
		val log = logService.create("test")
		val log2 = logRepository.findById(log.id)
		log2.map{assertEquals(log.id,it.id)}.orElseThrow()
	}
	@Test
	fun readList(){
		logService.create("test")
		logService.create("test2")
		assertEquals(logRepository.findAll().toList().size,2)
	}

	@Test
	fun readPage(){
		logService.create("test")
		logService.create("test2")
		val page = PageRequest.of(0,10)
		val logsPage = logRepository.findAll(page)
		assertEquals(logsPage.totalPages,1)
		assertEquals(logsPage.totalElements.toInt(),2)
	}

	@Test
	fun delete(){
		logService.create("test")
		logService.create("test2")
		val logs = logRepository.findAll()
		for (log in logs){
			logRepository.delete(log)
		}
		assertEquals(logRepository.findAll().toList().size,0)
	}

	@Test
	fun update(){
		val log = logService.create("update test")
		//생성
		assertEquals(
			logRepository.findAll()
				.filter{it.content=="update test"}.size,1)
		//수정
		log.content = "new content"
		logRepository.save(log)
		//결과 수정됨
		assertEquals(logRepository.findAll().toList().size,1)
		assertEquals(
			logRepository.findAll()
				.filter{it.content=="update test"}.size,0)
		assertEquals(
			logRepository.findAll()
				.filter{it.content=="new content"}.size,1)
	}

}
