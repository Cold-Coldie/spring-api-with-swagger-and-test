package com.coldie.roommateswithswaggerandtest.repository;

import com.coldie.roommateswithswaggerandtest.entity.Roommate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoommateRepository extends CrudRepository<Roommate, Long> {
    @Query("SELECT new com.coldie.roommateswithswaggerandtest.entity.Roommate(r.id, r.firstName, r.lastName, r.course, r.level) FROM Roommate r WHERE r.level = :level")
    List<Roommate> findRoommateByLevel(int level);
}
