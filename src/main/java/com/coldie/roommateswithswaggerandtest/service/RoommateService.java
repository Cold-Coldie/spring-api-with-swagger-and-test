package com.coldie.roommateswithswaggerandtest.service;

import com.coldie.roommateswithswaggerandtest.entity.Roommate;

import java.util.List;
import java.util.Optional;

public interface RoommateService {
    List<Roommate> retrieveAllRoommates();

    Optional<Roommate> retrieveRoommateById(Long id);

    List<Roommate> retrieveRoommateByLevel(int level);
}
