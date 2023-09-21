package io.pro.educare.application.school.retriver.list;

import io.pro.educare.Pagination;
import io.pro.educare.SearchQuery;
import io.pro.educare.employee.EmployeeGateway;


public class DefaultListSchool extends LIstSchoolUseCase {
    private final EmployeeGateway employeeGateway;

    public DefaultListSchool(EmployeeGateway employeeGateway) {
        this.employeeGateway = employeeGateway;
    }

    @Override
    public Pagination<ListSchoolOutput> execute(SearchQuery searchQuery) throws Exception {
        return this.employeeGateway.findAllBySchool(searchQuery).map(ListSchoolOutput::from);

    }

}
