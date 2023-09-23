package io.pro.educare.application.school;

import io.pro.educare.Pagination;
import io.pro.educare.SearchQuery;
import io.pro.educare.application.school.model.SchoolNeo4jEntity;
import io.pro.educare.application.school.persistence.SchoolNeo4jRepository;
import io.pro.educare.school.School;
import io.pro.educare.school.SchoolGateway;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.Node;
import org.neo4j.cypherdsl.core.Statement;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.core.Neo4jTemplate;

import static org.neo4j.cypherdsl.core.Cypher.*;

import java.util.Optional;
import java.util.UUID;

public class SchoolNeo4jGateway implements SchoolGateway {
    protected final SchoolNeo4jRepository schoolNeo4jRepository;
    protected final Neo4jTemplate neo4jTemplate;

    public SchoolNeo4jGateway(SchoolNeo4jRepository schoolNeo4jRepository, Neo4jTemplate neo4jTemplate) {
        this.schoolNeo4jRepository = schoolNeo4jRepository;

        this.neo4jTemplate = neo4jTemplate;
    }

    @Override
    public Optional<School> findById(UUID id) {
        return this.schoolNeo4jRepository.findById(id).map(SchoolNeo4jEntity::toAggregate);
    }

    @Override
    public School create(School school) {
        return this.schoolNeo4jRepository.save(SchoolNeo4jEntity.from(school)).toAggregate();
    }

    @Override
    public void deleteById(UUID id) {
        this.schoolNeo4jRepository.deleteById(id);
    }

    @Override
    public Pagination<School> findAll(SearchQuery searchQuery) {
        final var page = PageRequest.of(
                searchQuery.page(),
                searchQuery.offSet(),
                Sort.by(searchQuery.direction(), searchQuery.sorts())
        );
        final Node node = Cypher.node("school").named("s");
        final Statement statement = Cypher
                .match(node)
                .where(
                        property("s", "").contains(literalOf(""))
                ).returning("s").build();
        return null;
    }
}
