package org.example.repo;

import org.example.entity.Space;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceRepository extends CrudRepository<Space, Integer> {
}
