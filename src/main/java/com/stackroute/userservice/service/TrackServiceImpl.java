package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

  //override the save method from TrackService class and this method save all the tracks
    @Override
    public void saveTrack(Track track) {
         trackRepository.save(track);

    }

    //override the getAllTracks method from TrackService class and this method get all the tracks
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
//    @Override
//    public Track addNewTrack(Track track)
//    {
//        return trackRepository.save(track);
//    }
//override the Update method from TrackService class and this method update the tracks
    @Override
    public Track updateTrack(Track track)
    {
        return trackRepository.save(track);
    }

    //override the delete method from TrackService class and this method delete the track by given id
     @Override
     public void deleteTrackById(int id)
      {
        trackRepository.deleteById(id);
       }
}
