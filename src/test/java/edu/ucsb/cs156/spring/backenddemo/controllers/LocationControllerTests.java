<<<<<<< HEAD:src/test/java/edu/ucsb/cs156/spring/backenddemo/controllers/ZipCodeControllerTests.java
package edu.ucsb.cs156.spring.backenddemo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import edu.ucsb.cs156.spring.backenddemo.services.ZipCodeQueryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = ZipCodeController.class)
public class ZipCodeControllerTests {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ZipCodeQueryService mockZipCodeQueryService;
  
  
    @Test
    public void test_getZipCodes() throws Exception {
    
      String fakeJsonResult="{ \"fake\" : \"result\" }";
      String zipcode = "93106";
      when(mockZipCodeQueryService.getJSON(eq(zipcode))).thenReturn(fakeJsonResult);
  
      String url = String.format("/api/zipcode/get?zipcode=%s", zipcode);
  
      MvcResult response = mockMvc
          .perform( get(url).contentType("application/json"))
          .andExpect(status().isOk()).andReturn();
  
      String responseString = response.getResponse().getContentAsString();
  
      assertEquals(fakeJsonResult, responseString);
    }
  
  }
=======
package edu.ucsb.cs156.spring.backenddemo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import edu.ucsb.cs156.spring.backenddemo.services.LocationQueryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(value = LocationController.class)
public class LocationControllerTests {
  private ObjectMapper mapper = new ObjectMapper();
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  LocationQueryService mockLocationQueryService;


  @Test
  public void test_getLocation() throws Exception {
  
    String fakeJsonResult="{ \"fake\" : \"result\" }";
    String location = "IslaVista";
    when(mockLocationQueryService.getJSON(eq(location))).thenReturn(fakeJsonResult);

    String url = String.format("/api/locations/get?location=%s", location);

    MvcResult response = mockMvc
        .perform( get(url).contentType("application/json"))
        .andExpect(status().isOk()).andReturn();

    String responseString = response.getResponse().getContentAsString();

    assertEquals(fakeJsonResult, responseString);
  }

}
>>>>>>> 500aa961b42a69985afeb9732ae7a6ccf8c4c1b4:src/test/java/edu/ucsb/cs156/spring/backenddemo/controllers/LocationControllerTests.java
