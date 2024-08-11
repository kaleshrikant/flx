package com.shrikant.controller;

import com.shrikant.entity.Participant;
import com.shrikant.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<Participant> saveParticipant(@RequestBody Participant participant) {
        return new ResponseEntity<>(syncService.saveParticipant(participant), HttpStatus.CREATED);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<Participant> findParticipant(@PathVariable String employeeId) {
        if (Objects.nonNull(employeeId) && !employeeId.trim().isEmpty()) {
            Optional<Participant> optionalParticipant = syncService.findParticipant(employeeId);
            if (optionalParticipant.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).body(optionalParticipant.get());
            } else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/find")
    public ResponseEntity<Participant> findAllParticipants() {
        syncService.findAllParticipants();
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PutMapping("/update/{participant}")
    public ResponseEntity<Participant> updateParticipant(@RequestBody Participant participant) {
        return new ResponseEntity<>(syncService.updateParticipant(participant), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable String employeeId) {
        syncService.deleteParticipant(employeeId);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllParticipant() {
        syncService.deleteAllParticipant();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
