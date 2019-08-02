package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setId(10);
        track.setName("John");
        track.setComment("Jenny");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }

    //positive testcase for saveTrack
    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        //assertEquals
        Assert.assertEquals(10,fetchTrack.getId());

    }
    //negative testcase for saveTrack
    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(56,"regfmd","adwajd");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        //assertNotSame
        Assert.assertNotSame(testTrack,track);
    }
//testcase for getAllTracks
    @Test
    public void testGetAllTrack(){
        Track t1 = new Track(43,"djrdt","efjegnj");
        Track t2 = new Track(24,"wjqenw","sdsjrsn");
        trackRepository.save(t1);
        trackRepository.save(t2);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("wjqenw",list.get(0).getName());
    }
}

