package mu.webshop;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WebshopApplicationTests {
	private ApplicationContext applicationContext;
	@Test
	void contextLoads() {
		// Basic test to ensure that the Spring context loads successfully
		assertNotNull(applicationContext);
	}


}
