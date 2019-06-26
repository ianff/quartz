package me.zeph.quartz.example.quartzexample.springjob;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateDeliveryService {
  public void createDelivery(String id) {
    System.out.println("delivery created " + id + " at " + new Date().toString());
  }
}
