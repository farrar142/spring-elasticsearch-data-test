package estest.estest

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface LogRepository: ElasticsearchRepository<Log,Int>