package demo.springboot.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.springboot.test.dao.PersonRepository;
import demo.springboot.test.domain.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoSpringBootTestApplication.class)
@WebAppConfiguration
@Transactional
public class DemoSpringBootTestApplicationTests {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	WebApplicationContext webApplicationContext;
	MockMvc mockMvc;
	String expectedJson;

	@Before
	public void setup() throws JsonProcessingException {
		Person p1 = new Person("ryan");
		Person p2 = new Person("jack");
		Person p3 = new Person("tom");
		personRepository.save(p1);
		personRepository.save(p2);
		personRepository.save(p3);

		expectedJson = Obj2Json(personRepository.findAll());
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	private String Obj2Json(List<Person> obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	@Test
	public void testPersonController() throws Exception {
		String uri = "/person";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();

		Assert.assertEquals("Wrong, the expected status is 200.", 200, status);
		Assert.assertEquals("Wrong, the expected content doesn't match the acutal value.", expectedJson, content);
	}

}
