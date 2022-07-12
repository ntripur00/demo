package com.example.demo.service;

import com.example.demo.pojo.DemoObject;

public interface DemoService {
  void queryGoogle(String query, String start);

  DemoObject findDemoObject();
}
