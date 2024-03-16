package com.coldie.roommateswithswaggerandtest.service;

import com.coldie.roommateswithswaggerandtest.entity.Roommate;
import com.coldie.roommateswithswaggerandtest.repository.RoommateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoommateServiceImpl implements RoommateService {
    @Autowired
    RoommateRepository roommateRepository;

    @Override
    public List<Roommate> retrieveAllRoommates() {
        return (List<Roommate>) roommateRepository.findAll();
    }

    @Override
    public Optional<Roommate> retrieveRoommateById(Long id) {
        return roommateRepository.findById(id);
    }

    @Override
    public List<Roommate> retrieveRoommateByLevel(int level) {
        return roommateRepository.findRoommateByLevel(level);
    }
}
