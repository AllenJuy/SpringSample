import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pers.tao.springmvc.ControllerSample;

/**
 * Created by tao on 17-6-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:spring-config.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")
})
public class ControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Before
    public void setUp(){
//        ControllerSample controllerSample = new ControllerSample();
//        mockMvc = MockMvcBuilders.standaloneSetup(controllerSample).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testController() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/mvc/hello"))
                                .andExpect(MockMvcResultMatchers.view().name("mvc/view"))
                                .andExpect(MockMvcResultMatchers.model().attributeExists("mvc"))
                                .andDo(MockMvcResultHandlers.print())
                                .andReturn();
        Assert.assertNotNull(mvcResult.getModelAndView().getModel().get("mvc"));
    }
}
