package com.ativ.model;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
  private @Id @GeneratedValue  long empId;
  private String name;
  private String designation;
  private double salary;

  public Employee() {}

  public Employee(String name, String designation, double salary) {
    this.name = name;
    this.designation = designation;
    this.salary = salary;
  }

}
