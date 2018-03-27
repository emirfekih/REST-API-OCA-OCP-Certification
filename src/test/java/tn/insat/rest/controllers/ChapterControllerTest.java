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
import tn.insat.rest.services.ChapterService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by zied on 25/02/2018.
 */
public class ChapterControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ChapterService chapterService;

    @InjectMocks
    private ChapterController chapterController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(chapterController)
                .build();
    }

    @Test
    public void getChapters() throws Exception {
        List<Chapter> chapters = Arrays.asList(
                new Chapter("Generics"),
                new Chapter("Collections"));
        when(chapterService.getChapters()).thenReturn(chapters);
        mockMvc.perform(get("/chapters/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].chapterName", is("Generics")))
                .andExpect(jsonPath("$[1].chapterName", is("Collections")));
        verify(chapterService, times(1)).getChapters();
        verifyNoMoreInteractions(chapterService);
    }

    @Test
    public void findByChapterId() throws Exception{
        Chapter chapter = new Chapter("Generics");
        when(chapterService.findByChapterId(1)).thenReturn(chapter);
        mockMvc.perform(get("/chapters/{chapterId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.chapterName", is("Generics")));
        verify(chapterService, times(1)).findByChapterId(1);
        verifyNoMoreInteractions(chapterService);
    }
}