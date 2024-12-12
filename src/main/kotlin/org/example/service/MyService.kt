package org.example.service

import org.example.model.MyDocument
import org.example.repository.MyRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class MyService(
	private val myRepository: MyRepository
) {

	suspend fun findMeIfYouCan(ids: List<String>): Mono<List<MyDocument>> {
		return myRepository.findAllById(ids).collectList()
	}
}