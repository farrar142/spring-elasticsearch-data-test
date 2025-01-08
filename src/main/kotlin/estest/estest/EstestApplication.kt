package estest.estest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EstestApplication

fun main(args: Array<String>) {
	runApplication<EstestApplication>(*args)
}
