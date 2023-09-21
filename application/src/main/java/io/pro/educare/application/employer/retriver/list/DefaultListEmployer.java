package io.pro.educare.application.employer.retriver.list;

import io.pro.educare.Pagination;
import io.pro.educare.SearchQuery;
import io.pro.educare.employee.EmployeeGateway;


public class DefaultListEmployer extends LIstEmployerUseCase {
    private final EmployeeGateway employeeGateway;

    public DefaultListEmployer(EmployeeGateway employeeGateway) {
        this.employeeGateway = employeeGateway;
    }

    @Override
    public Pagination<ListEmployerOutput> execute(SearchQuery searchQuery) throws Exception {
        return this.employeeGateway.findAllBySchool(searchQuery).map(ListEmployerOutput::from);

    }

}
