package estest.estest

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.DateFormat
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.UUID

@Document(indexName = "test-log")
class Log (val content:String,
           @Id val id: String = UUID.randomUUID().toString(),
           @Field(type = FieldType.Date, format = [DateFormat.date_time])
           val createAt:OffsetDateTime=OffsetDateTime.now(ZoneOffset.UTC)
){

}