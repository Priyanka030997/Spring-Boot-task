package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.service.TrackService;
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

    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }
    @PostMapping(value="/save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("sucessfully created", HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping(value="/track")
    public ResponseEntity<?> getAllTracks()
    {
      return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @PostMapping(value="/update")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.updateTrack(track);
            responseEntity=new ResponseEntity<String>("sucessfully updated", HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;
        try
        {
        trackService.deleteTrackById(id);
        responseEntity=new ResponseEntity<String>("sucessfully deleted", HttpStatus.CREATED);
    }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping(value="/trackbyname/{name}")
    public ResponseEntity<?> trackByName(@PathVariable("name") String name)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.trackByName(name);
            responseEntity=new ResponseEntity<String>("sucessfully trackByName", HttpStatus.CREATED);
        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
