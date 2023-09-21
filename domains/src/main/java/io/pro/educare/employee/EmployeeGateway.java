package io.pro.educare.employee;

import io.pro.educare.Pagination;
import io.pro.educare.Production;
import io.pro.educare.SearchQuery;

import java.util.Optional;
import java.util.UUID;

@Production(Production.Stage.PRODUCED)
public interface EmployeeGateway {
    Optional<Employee> findById(UUID id);

    Employee create(Employee people);

    Employee update(Employee employee);

    void deleteById(UUID id);

    Pagination<Employee> findAllBySchool(SearchQuery searchQuery);
}
