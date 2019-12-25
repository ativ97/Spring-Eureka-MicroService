package com.ativ.controller;

import com.ativ.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestController {
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "/employee", method = RequestMethod.GET)
  public Employee firstPage(
      @RequestParam(value = "name", defaultValue = "employeeName") String name,
      @RequestParam(value = "designation", defaultValue = "employee") String designation,
      @RequestParam(value = "salary", defaultValue = "100") int salary) {

    Employee emp = new Employee();
    emp.setName(name);
    emp.setDesignation(designation);
    emp.setEmpId(counter.incrementAndGet());
    emp.setSalary(salary);
    return emp;
  }
}
