package com.shrikant.service;

import com.shrikant.entity.Participant;
import com.shrikant.repository.SyncRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SyncService {

    private final SyncRepository syncRepository;


    public Participant saveParticipant(Participant participant) {
        return syncRepository.save(participant);
    }

    public Optional<Participant> findParticipant(String employeeId) {
        return syncRepository.findById(employeeId);
    }

    public List<Participant> findAllParticipants() {
        return syncRepository.findAll();
    }

    public Participant updateParticipant(Participant participant) {
        return syncRepository.save(participant);
    }

    public void deleteParticipant(String employeeId) {
        syncRepository.deleteById(employeeId);
    }

    public void deleteAllParticipant() {
        syncRepository.deleteAll();
    }

}
