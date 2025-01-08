package estest.estest

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.time.LocalDateTime

@Document(indexName = "test-log")
class Log (val content:String,@Id val id: Int=0, val createAt:LocalDateTime=LocalDateTime.now())