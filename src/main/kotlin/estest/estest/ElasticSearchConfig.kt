package estest.estest

import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

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