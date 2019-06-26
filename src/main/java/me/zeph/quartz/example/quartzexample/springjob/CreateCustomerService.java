package me.zeph.quartz.example.quartzexample.springjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateCustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public void createDelivery(String id) {
    int size = customerRepository.findAll().size();
    System.out.println("Find customer count " + size + " at " + new Date().toString());
  }
}
