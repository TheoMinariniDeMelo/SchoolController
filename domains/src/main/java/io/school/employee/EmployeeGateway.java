package io.school.employee;

import io.school.Pagination;
import io.school.Production;
import io.school.address.Address;

import java.util.Optional;
import java.util.UUID;

@Production(Production.Stage.PRODUCED)
public interface EmployeeGateway {
    Optional<Employee> findById(UUID id);

    Employee create(Employee people);

    void deleteById(UUID id);

    Pagination<Employee> findAll();
}
