package example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
	@Autowired
	TestRestTemplate rest;

	@Test
	public void foundIsWrapped() {
		assertWrapped("/");
	}

	// fails on Jetty
	@Test
	public void notFoundIsWrapped() {
		assertWrapped("/notfound");
	}

	private void assertWrapped(String url) {
		String body = this.rest.getForObject(url, String.class);
		assertThat(body).contains("Request Wrapped? <span>true</span>");
	}
}
