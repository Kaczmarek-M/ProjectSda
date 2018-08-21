package com.barterownia.service;

import com.barterownia.model.VideoGame;
import com.barterownia.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    public List<VideoGame> findVideoGameByTitle(String title){
        return videoGameRepository.findVideoGameByTitle(title);
    }

    public List<VideoGame> findByPlatform (String platform) {
        return videoGameRepository.findByPlatform(platform);
    }

    public List<VideoGame> findByGenre (String genre) {
        return videoGameRepository.findByGenre(genre);
    }

    public List<VideoGame> findByPriceCompartment(long min, long max)  {
        return videoGameRepository.findByPrice(min, max);
    }

    public List<VideoGame> findNew (boolean yes) {
        return videoGameRepository.findNew(yes);
    }

    public List<VideoGame> findUsed (boolean no) {
        return  videoGameRepository.findUsed(no);
    }

    public List<VideoGame> findByPegi (int pegi) {
        return videoGameRepository.findByPegi(pegi);
    }
}
