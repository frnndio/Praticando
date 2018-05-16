package rest.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import rest.RestApplication;
import rest.project.Project;
import rest.project.ProjectService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes={RestApplication.class, ProjectService.class})
public class ProjectServiceTest {
	
	@Value("${local.server.port}")
	private int port;
	
	private TestRestTemplate restTemplate = new TestRestTemplate();
		
	@Test
	public void ProjectVazio() {
		ResponseEntity response = this.restTemplate.getForEntity("http://localhost:{port}/project", Project.class, this.port);
		assertEquals(null, response.getBody());
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	
	
	
	
	

}
