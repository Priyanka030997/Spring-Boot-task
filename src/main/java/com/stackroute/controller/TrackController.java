package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {
    @Autowired
    TrackService trackService;
    @Autowired
    ErrorController errorController;


    public TrackController(TrackService trackService) {

        this.trackService = trackService;
    }
    //handler method for save all the tracks
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
           // calls saveTrack() from service
            responseEntity = new ResponseEntity<Track>(trackService.saveTrack(track), HttpStatus.CREATED);
        } catch (TrackAlreadyExistException ex) {
            //responseEntity = errorController.exception1();
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //handler method for get all the tracks
    @GetMapping(value = "/track")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    //handler method for update the track
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
           // calls updateTrack() from service
            responseEntity = new ResponseEntity<Track>(trackService.updateTrack(id,track), HttpStatus
        } catch (TrackNotFoundException ex) {
            responseEntity = errorController.exception2();
        }
        return responseEntity;
    }

    //handler method for delete the track by given Id
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        try {
            responseEntity=new ResponseEntity<Track>(trackService.deleteTrackById(id), HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
