package com.shrikant.service;

import com.shrikant.dto.ParticipantDTO;
import com.shrikant.entity.Participant;
import com.shrikant.repository.OfferGeneratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferGeneratorService {

    private final OfferGeneratorRepository offerGeneratorRepository;

    public Participant saveOffer(Participant participant) {
        return offerGeneratorRepository.save(participant);
    }

    public Optional<Participant> findOffer(String employeeId) {
        return offerGeneratorRepository.findById(employeeId);
    }

    public List<Participant> findAllOffer() {
        return offerGeneratorRepository.findAll();
    }

    public Participant updateOffer(ParticipantDTO participantDto) {
        Participant participant = Participant.builder()
                .employeeId(participantDto.getEmployeeId())
                .accountName(participantDto.getAccountName())
                .offerId(participantDto.getOfferId())
                .build();
        return offerGeneratorRepository.save(participant);
    }

    public void deleteOffer(String employeeId) {
        offerGeneratorRepository.deleteById(employeeId);
    }

    public void deleteAllOffer() {
        offerGeneratorRepository.deleteAll();
    }

}
