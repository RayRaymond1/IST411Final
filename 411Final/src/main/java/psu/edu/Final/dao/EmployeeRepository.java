package psu.edu.Final.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import psu.edu.Final.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it ... no need to write any code LOL!
}