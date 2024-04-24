package edu.ucsb.cs156.spring.backenddemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import edu.ucsb.cs156.spring.backenddemo.beans.CollegeSubreddit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestClientTest(UniversityQueryService.class)

public class UniversityQueryServiceTests {
    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private UniversityQueryService universityQueryService;

    public static final String ENDPOINT = "http://universities.hipolabs.com/search?name={name}";

    @Test
    public void test_getJSON() {
        String name = "Stanford";
        String expectedURL = UniversityQueryService.ENDPOINT.replace("{name}", name);
        String fakeJsonResult = "[{\"web_pages\": [\"http://www.stanford.edu/\"], \"alpha_two_code\": \"US\", \"state-province\": null, \"domains\": [\"stanford.edu\"], \"name\": \"Stanford University\", \"country\": \"United States\"}]";

        this.mockRestServiceServer.expect(requestTo(expectedURL))
          .andExpect(header("Accept", MediaType.APPLICATION_JSON.toString()))
          .andExpect(header("Content-Type", MediaType.APPLICATION_JSON.toString()))
          .andRespond(withSuccess(fakeJsonResult, MediaType.APPLICATION_JSON));
        String actualResult = universityQueryService.getJSON(name);
        assertEquals(fakeJsonResult, actualResult);
    }

}