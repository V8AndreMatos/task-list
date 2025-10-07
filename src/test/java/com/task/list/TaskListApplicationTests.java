package com.task.list;

import com.task.list.entity.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.task.list.dto.TaskListDTO;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTaskSuccess() {
		var task = new TaskList(null, "task one", "desc task one", false, 1);

		webTestClient
				.post()
				.uri("/tasks")
				.bodyValue(task)
				.exchange()
				.expectStatus().isCreated()
				.expectHeader().exists("Location")
				.expectBody()
				.jsonPath("$.name").isEqualTo(task.getName())
				.jsonPath("$.description").isEqualTo(task.getDescription())
				.jsonPath("$.performed").isEqualTo(task.isPerformed())
				.jsonPath("$.priority").isEqualTo(task.getPriority());
	}


	@Test
	void testCreateTaskFail() {
		var invalidTask = new TaskListDTO(null, "", "", false, 0);

		webTestClient
				.post()
				.uri("/tasks")
				.bodyValue(invalidTask)
				.exchange()
				.expectStatus().isBadRequest() // 400 Bad Request
				.expectBody()
				.jsonPath("$.errors.name").exists()
				.jsonPath("$.errors.description").exists()
				.jsonPath("$.errors.priority").exists();
	}


}
