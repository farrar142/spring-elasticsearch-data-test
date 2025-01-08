package estest.estest

import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Configuration
@EnableElasticsearchRepositories
class ElasticSearchConfig : ElasticsearchConfiguration() {
    override fun clientConfiguration():ClientConfiguration{
        return ClientConfiguration.
        builder().
        connectedTo("localhost:9200").
        withBasicAuth("elastic","password").
        build()
    }
}