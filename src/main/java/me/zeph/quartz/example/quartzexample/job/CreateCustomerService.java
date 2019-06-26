package me.zeph.quartz.example.quartzexample.job;

import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService {
  public void createCustomer(String customerId) {
    System.out.println("customer created " + customerId);
  }
}
