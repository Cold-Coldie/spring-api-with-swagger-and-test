package com.coldie.roommateswithswaggerandtest.web;

import com.coldie.roommateswithswaggerandtest.entity.Roommate;
import com.coldie.roommateswithswaggerandtest.exception.RoommateNotFoundException;
import com.coldie.roommateswithswaggerandtest.exception.UnexpectedErrorException;
import com.coldie.roommateswithswaggerandtest.service.RoommateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RoommateController {
    @Autowired
    RoommateService roommateService;

    @Operation(
            description = "Get all roommates.",
            summary = "This endpoint returns all the roommates available"
    )
    @GetMapping("/roommates")
    public ResponseEntity<List<Roommate>> getAllRoommates() {
        try {
            List<Roommate> roommates = roommateService.retrieveAllRoommates();
            return new ResponseEntity<List<Roommate>>(roommates, HttpStatus.OK);
        } catch (UnexpectedErrorException exception) {
            throw exception;
        }
    }

    @Operation(
            description = "Get roommate by \"id\".",
            summary = "This endpoint returns the roommate that matches the \"id\" parameter."
    )
    @GetMapping("/roommate/{id}")
    public ResponseEntity<Optional<Roommate>> getRoommateById(@PathVariable Long id) {
        try {
            Optional<Roommate> optionalRoommate = roommateService.retrieveRoommateById(id);
            if (optionalRoommate.isPresent()) {
                return new ResponseEntity<Optional<Roommate>>(optionalRoommate, HttpStatus.OK);
            } else {
                throw new RoommateNotFoundException("Roommate not found with id: " + id);
            }
        } catch (RoommateNotFoundException exception) {
            throw exception;
        }
    }

    @Operation(
            description = "Get roommate by \"level\".",
            summary = "This endpoint returns all roommates that match the \"level\" parameter."
    )
    @GetMapping("/roommate/level/{level}")
    public ResponseEntity<List<Roommate>> getRoommateByLevel(@PathVariable int level) {
        try {
            List<Roommate> roommate = roommateService.retrieveRoommateByLevel(level);
            return new ResponseEntity<List<Roommate>>(roommate, HttpStatus.OK);
        } catch (UnexpectedErrorException exception) {
            throw exception;
        }
    }
}
