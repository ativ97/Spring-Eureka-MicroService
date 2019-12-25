package com.ativ.controller;

import com.ativ.model.Employee;
import com.ativ.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestController {
  private final EmployeeRepository repository;

  TestController(EmployeeRepository repository){
    this.repository = repository;
  }

  @GetMapping("/employees")
  List<Employee> all(){
    return repository.findAll();
  }

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmplyee){
    return repository.save(newEmplyee);
  }

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id){
    return repository.findOne(id);
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id){
    repository.delete(id);
  }

  /*@RequestMapping(value = "/employee", method = RequestMethod.GET)
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
  }*/
}
