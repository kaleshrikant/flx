package com.shrikant.repository;

import com.shrikant.entity.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyncRepository extends MongoRepository<Participant, String> {
}
