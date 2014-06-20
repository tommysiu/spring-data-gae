package test.springdata.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.springdata.sample.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}