package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//extends all the methods of the JPA Repository
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

}
