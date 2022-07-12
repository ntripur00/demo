package com.example.demo.service;

import com.example.demo.pojo.DemoObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService{
  @Override
  public DemoObject findDemoObject( ){
    DemoObject demoObject = new DemoObject();
    demoObject.setName("Hello");
    demoObject.setDemo("World");
      log.debug("the Demo Object is {}",demoObject);
    return demoObject;
  }

  @Override
  public void queryGoogle(String query, String start) {

    String url = "https://www.google.com" + "/search" + "?q="+query ;
//    String url = "http://localhost:8090/demo/api/all";
    if(!start.isEmpty())
      url+="&start=" + start;
     log.debug("\n\n\n\nthe url is {}",url);
    RestTemplate   restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//    headers.set("X-COM-PERSIST", "NO");
//    headers.set("X-COM-LOCATION", "USA");

    HttpEntity<String> entity = new HttpEntity<String>(headers);

    ParameterizedTypeReference<Object> responseType =
     new ParameterizedTypeReference<Object>() {};

     ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
      log.debug("the result is {}",responseEntity.getBody());


  }
}
