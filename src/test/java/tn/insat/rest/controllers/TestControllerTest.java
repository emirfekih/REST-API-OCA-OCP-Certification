package tn.insat.rest.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.insat.rest.entities.Chapter;
import tn.insat.rest.services.TestService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zied on 02/03/2018.
 */
public class TestControllerTest {

    MockMvc mockMvc;

    @Mock
    TestService testService;

    @InjectMocks
    TestController testController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @org.junit.Test
    public void getTests() throws Exception {
        List<tn.insat.rest.entities.Test> tests = Arrays.asList(
                new tn.insat.rest.entities.Test("test","test"),
                new tn.insat.rest.entities.Test("Test2","OCA"));
        when(testService.getTests()).thenReturn(tests);
        mockMvc.perform(get("/tests/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].testName", is("test")))
                .andExpect(jsonPath("$[0].testType", is("test")))
                .andExpect(jsonPath("$[1].testName", is("Test2")))
                .andExpect(jsonPath("$[1].testType", is("OCA")));
        verify(testService, times(1)).getTests();
        verifyNoMoreInteractions(testService);

    }

//    @org.junit.Test
//    public void findByTestId() throws Exception {
//        tn.insat.rest.entities.Test test = new tn.insat.rest.entities.Test("test","test");
//        when(testService.findByTestId(1)).thenReturn(test);
//        mockMvc.perform(get("/test/{testId}", 1))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$.testName", is("test")))
//                .andExpect(jsonPath("$.testType", is("test")));
//        verify(testService, times(1)).findByTestId(1);
//        verifyNoMoreInteractions(testService);
//    }

}