package com.shrikant.repository;

import com.shrikant.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferGeneratorRepository extends JpaRepository<Participant,String > {
}
