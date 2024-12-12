package org.example.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document
data class MyDocument(
	@Id
	var id: String,
	val value: String
) : Serializable

