package com.shrikant.repository;

import com.shrikant.entity.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RcbBldRepository extends CrudRepository<Participant, String> {
}
