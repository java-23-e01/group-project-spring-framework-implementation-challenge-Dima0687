package de.eisnerdietmar.employeecrud.services;

import de.eisnerdietmar.employeecrud.dao.EmployeeRepository;
import de.eisnerdietmar.employeecrud.enitity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository empRepo;

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return empRepo.save( employee );
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> dbEmployee = empRepo.findById( id );

        return dbEmployee.orElseThrow( () -> new RuntimeException("No Employee with id - " + id ));
    }

    @Override
    public List<Employee> findAll() {
        return empRepo.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        empRepo.deleteById( id );
    }
}
