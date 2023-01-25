package ru.eisbrecher.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eisbrecher.springboot.entity.Fine;

@Repository
public interface FineRepository extends JpaRepository<Fine, Integer> {
}
