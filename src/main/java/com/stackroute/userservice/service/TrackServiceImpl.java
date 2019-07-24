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
    @Override
    public void saveTrack(Track track) {
         trackRepository.save(track);

    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
//    @Override
//    public Track addNewTrack(Track track)
//    {
//        return trackRepository.save(track);
//    }
    @Override
    public Track updateTrack(Track track)
    {
        return trackRepository.save(track);
    }
     @Override
     public void deleteTrackById(int id)
      {
        trackRepository.deleteById(id);
       }
}
