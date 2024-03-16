package com.coldie.roommateswithswaggerandtest.web;

import com.coldie.roommateswithswaggerandtest.entity.Roommate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebMvc
public class RoommateControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void getAllRoommates() {
        ResponseEntity<List> response = this.testRestTemplate.getForEntity("http://localhost:" + port + "/roommates", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getRoommateById() {
        ResponseEntity<Roommate> response = this.testRestTemplate.getForEntity("http://localhost:" + port + "/roommate/1", Roommate.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getRoommateByLevel() {
        ResponseEntity<List> response = this.testRestTemplate.getForEntity("http://localhost:" + port + "/roommate/level/100", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
