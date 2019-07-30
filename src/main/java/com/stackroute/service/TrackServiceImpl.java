package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistException();
        }
        Track savedtrack = trackRepository.save(track);
        if (savedtrack == null) {
            throw new TrackAlreadyExistException();
        }
        return savedtrack;
//throw new TrackAlreadyExistException();
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
    public Track updateTrack(Track track) throws TrackNotFoundException {
        if (trackRepository.existsById(track.getId())) {
            Track track1 = trackRepository.findById(track.getId()).get();
            track1.setComment(track.getComment());
            trackRepository.save(track1);
            return track1;
        } else {
            throw new TrackNotFoundException();
        }

        //return trackRepository.save(track);
    }

    @Override
    public void deleteTrackById(int id) {

        trackRepository.deleteById(id);
    }

}
