package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SpringContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    TrackService trackService;

    public SpringContextListener(TrackService trackService) {
        this.trackService = trackService;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            trackService.saveTrack(new Track(26, "sndue", "uiwd"));
            trackService.saveTrack(new Track(34, "wedwe", "defewd"));
            trackService.saveTrack(new Track(54, "qwnqeue", "andjwe"));

        } catch (Exception exception) {
            System.out.println("exception handler");
        }
    }
}
