package com.bootStart.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletConfig.class)
@WebAppConfiguration
public class HelloControllerTest {
	private MockMvc mock;
	
	@Before
	public void before(){
		this.mock = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void testSay() throws Exception{
		mock.perform(MockMvcRequestBuilders.get("/hello/say").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
//			.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Hello World!")));
			.andExpect(MockMvcResultMatchers.content().string("Hello World!"));
	}

}
