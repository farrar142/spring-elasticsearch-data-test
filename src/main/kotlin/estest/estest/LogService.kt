package estest.estest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LogService {
    @Autowired lateinit var logRepository:LogRepository
    fun create(content:String){
        val log = Log(content)
        logRepository.save(log)
    }
}