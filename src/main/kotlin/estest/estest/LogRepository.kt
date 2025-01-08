package estest.estest

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface LogRepository: ElasticsearchRepository<Log,String>{
    fun findByContent(content:String):List<Log>
    fun findByContent(page:Pageable,content:String):Page<Log>
}