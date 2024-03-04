package de.eisnerdietmar.employeecrud.dao;

import de.eisnerdietmar.employeecrud.enitity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
