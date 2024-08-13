package com.shrikant.service;

import com.shrikant.dto.ParticipantDTO;
import com.shrikant.entity.Participant;
import com.shrikant.exception.EmployeeNotFoundException;
import com.shrikant.repository.RcbBldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RcbBldService {

    private final RcbBldRepository rcbBldRepository;


    public Participant saveParticipant(Participant participant) {
        return rcbBldRepository.save(participant);
    }

    public Optional<Participant> findParticipant(String employeeId) {
        return rcbBldRepository.findById(employeeId);
    }

    public List<Participant> findAllParticipants() {
        return (List<Participant>) rcbBldRepository.findAll();
    }

    public Participant updateParticipant(ParticipantDTO participantDto) {
        Participant participant;

        Optional<Participant> participantFound = rcbBldRepository.findById(participantDto.getEmployeeId());
        if (Objects.nonNull(participantFound)) {
            participant = Participant.builder()
                        .employeeId(participantDto.getEmployeeId())
                        .name(participantDto.getName())
                        .age(participantDto.getAge())
                        .city(participantDto.getCity())
                    .build();
            rcbBldRepository.save(participant);
            return participant;
        } else throw new EmployeeNotFoundException("EMPLOYEE NOT FOUND");
    }

    public void deleteParticipant(String employeeId) {
        rcbBldRepository.deleteById(employeeId);
    }

    public void deleteAllParticipant() {
        rcbBldRepository.deleteAll();
    }
}
