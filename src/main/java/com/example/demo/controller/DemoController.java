package com.example.demo.controller;


import com.example.demo.pojo.DemoObject;
import com.example.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {
  @Autowired
  private DemoService demoService;

  @RequestMapping("/demo/api/all")
  public DemoObject findDemoObject() {
    DemoObject demo = demoService.findDemoObject();
    return demo;
  }


  @RequestMapping(value = "/demo/api/querygoogle", produces = MediaType.APPLICATION_XML_VALUE,method = RequestMethod.GET)

  public void queryGoogle(@RequestParam(name = "query") String query, @RequestParam(name = "start" , required = false,defaultValue = "10") String start) {
    demoService.queryGoogle(query, start);
//    https://www.google.com/search?q=unitprot
//    https://www.google.com/search?q=uniprot&start=30

  }
}
