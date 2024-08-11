package com.shrikant.controller;

import com.shrikant.entity.Participant;
import com.shrikant.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/sync")
public class SyncController {

    private final SyncService syncService;

    @Autowired
    public SyncController(SyncService syncService) {
        this.syncService = syncService;
    }


    @PostMapping("/save")
    public ResponseEntity<Participant> saveParticipant(Participant participant) {
        return new ResponseEntity<>(syncService.saveParticipant(participant), HttpStatus.CREATED);
    }

    @GetMapping("/find/{participantId}")
    public ResponseEntity<Participant> findParticipant(@PathVariable Integer participantId) {
        return new ResponseEntity<>(syncService.findParticipant(participantId), HttpStatus.FOUND);
    }

    @GetMapping("/find")
    public ResponseEntity<Participant> findAllParticipants() {
        syncService.findAllParticipants();
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PutMapping("/update/{participant}")
    public ResponseEntity<Participant> updateParticipant(@PathVariable Participant participant) {
        return new ResponseEntity<>(syncService.updateParticipant(participant), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{participantId}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Integer participantId) {
        syncService.deleteParticipant(participantId);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllParticipant() {
        syncService.deleteAllParticipant();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
