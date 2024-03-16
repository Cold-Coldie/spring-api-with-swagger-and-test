package com.coldie.roommateswithswaggerandtest.web;

import com.coldie.roommateswithswaggerandtest.service.RoommateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(RoommateController.class)
public class RoommateControllerUnitTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    RoommateService roommateService;

    @Test
    public void getAllRoommates() throws Exception {
        mockMvc.perform(get("/roommates"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(roommateService, times(1)).retrieveAllRoommates();
    }

    @Test
    public void getRoommateById() throws Exception {
        mockMvc.perform(get("/roommate/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{}"));

        verify(roommateService, times(1)).retrieveRoommateById(1L);
    }

    @Test
    public void getRoommateByLevel() throws Exception {
        mockMvc.perform(get("/roommate/level/100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(roommateService, times(1)).retrieveRoommateByLevel(100);
    }
}
