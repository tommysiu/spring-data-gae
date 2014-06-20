package test.springdata.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.springdata.sample.domain.Parent;

public interface ParentRepository extends JpaRepository<Parent, String> {
}
