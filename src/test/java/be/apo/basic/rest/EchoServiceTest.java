package be.apo.basic.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import be.apo.basic.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EchoServiceTest {
	
	@Autowired
	private EchoService echoService;
    @Autowired
    private WebApplicationContext webApplicationContext;
    
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void echoTest() throws Exception{
		mockMvc.perform(get("/echo")).andExpect(content().string("World"));
	}
	
	@Test
	public void echoTestWithParam() throws Exception{
		String param = "hello";
		mockMvc.perform(get(EchoService.ECHO_MAPPING).param("name", param)).andExpect(content().string(param));
	}

}
