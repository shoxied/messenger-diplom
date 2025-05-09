package org.example.repo;

import org.example.entity.Chats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends CrudRepository<Chats, Integer> {
}
