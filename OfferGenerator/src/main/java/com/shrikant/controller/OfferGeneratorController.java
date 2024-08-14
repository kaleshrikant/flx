package com.shrikant.controller;

import com.shrikant.dto.ParticipantDTO;
import com.shrikant.entity.Participant;
import com.shrikant.service.OfferGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/mclbs")
@RequiredArgsConstructor
public class OfferGeneratorController {

    private final OfferGeneratorService offerGeneratorService;

    @PostMapping("/save")
    public ResponseEntity<Participant> saveOffer(@RequestBody Participant participant) {
        return new ResponseEntity<>(offerGeneratorService.saveOffer(participant), HttpStatus.CREATED);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<Participant> findOffer(@PathVariable String employeeId) {
        if (Objects.nonNull(employeeId) && !employeeId.trim().isEmpty()) {
            Optional<Participant> optionalParticipant = offerGeneratorService.findOffer(employeeId);
            if (optionalParticipant.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(optionalParticipant.get());
            } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Participant>> findAllParticipants() {
        List<Participant> allParticipants = offerGeneratorService.findAllOffer();
        if (!allParticipants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(allParticipants.stream().collect(Collectors.toUnmodifiableList()));
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Participant> updateParticipant(@RequestBody ParticipantDTO participantDto) {
        Participant participant = offerGeneratorService.updateOffer(participantDto);

        if (Objects.nonNull(participant)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(participant);
        } else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable String employeeId) {
        if (Objects.nonNull(employeeId) && !employeeId.trim().isEmpty()) {
            offerGeneratorService.deleteOffer(employeeId);
            return new ResponseEntity<>(HttpStatus.GONE);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllParticipant() {
        offerGeneratorService.deleteAllOffer();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
