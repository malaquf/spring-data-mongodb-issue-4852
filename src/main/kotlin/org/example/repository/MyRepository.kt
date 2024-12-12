package org.example.repository

import org.example.model.MyDocument
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.mongodb.repository.Meta
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MyRepository : ReactiveMongoRepository<MyDocument, String> {

	@Meta(maxExecutionTimeMs = 10000)
	@Cacheable("myCache")
	override fun findAllById(ids: Iterable<String>): Flux<MyDocument>

	@Meta(maxExecutionTimeMs = 10000)
	@Cacheable("myCache")
	override fun findById(id: String): Mono<MyDocument>
}