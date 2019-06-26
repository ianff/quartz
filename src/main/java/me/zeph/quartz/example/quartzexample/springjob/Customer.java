package me.zeph.quartz.example.quartzexample.springjob;

import javax.persistence.*;

@Table(name = "customer")
@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;

}
