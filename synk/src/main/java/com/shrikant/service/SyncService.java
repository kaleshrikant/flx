package com.shrikant.service;

import com.shrikant.entity.Participant;
import com.shrikant.repository.SyncRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SyncService {

    private final SyncRepository syncRepository;


    public Participant saveParticipant(Participant participant) {
        return syncRepository.save(participant);
    }

    public Participant findParticipant(Integer participantId) {
        return syncRepository.findById(participantId).get();
    }

    public List<Participant> findAllParticipants() {
        return syncRepository.findAll();
    }

    public Participant updateParticipant(Participant participant) {
        return syncRepository.save(participant);
    }

    public void deleteParticipant(Integer participantId) {
        syncRepository.deleteById(participantId);
    }

    public void deleteAllParticipant() {
        syncRepository.deleteAll();
    }

}
