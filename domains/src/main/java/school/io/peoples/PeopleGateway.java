package school.io.peoples;

import school.io.Pagination;
import school.io.school.School;

import java.util.Optional;
import java.util.UUID;

public interface PeopleGateway {
    Optional<People> findById(UUID id);

    People save(People people);

    void deleteById(UUID id);

    Pagination<People> findAll();
}
