package de.eisnerdietmar.employeecrud.services;

import de.eisnerdietmar.employeecrud.enitity.Employee;

import java.util.List;

public interface EmployeeService {
    // create and update
    Employee save( Employee employee );

    // read
    Employee findById( Long id );
    List<Employee> findAll();

    // delete
    void deleteById( Long id );
}
