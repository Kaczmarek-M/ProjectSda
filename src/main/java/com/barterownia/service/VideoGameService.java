package com.barterownia.service;

import com.barterownia.model.VideoGame;
import com.barterownia.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {


    @Autowired
    private VideoGameRepository videoGameRepository;

    public List<VideoGame> findAll() {
        return videoGameRepository.findAll();
    }

    public Optional<VideoGame> findByID(long id) {
        return videoGameRepository.findById(id);
    }

    public List<VideoGame> findVideoGameByTitle(String title) {
        return videoGameRepository.findAllByTitleContaining(title);
    }

    public List<VideoGame> findByGenre(String genre) {
        return videoGameRepository.findAllByGenreContaining(genre);
    }

    public List<VideoGame> findByPlatform(String platform) {
        return videoGameRepository.findAllByPlatformContaining(platform);
    }

    public List<VideoGame> findByPublisher(String publisher) {
        return videoGameRepository.findAllByPublisherContaining(publisher);
    }

    public List<VideoGame> findNew() {
        return videoGameRepository.findAllByIsNewIsTrue();
    }

    public List<VideoGame> findUsed() {
        return videoGameRepository.findAllByIsNewIsFalse();
    }

    public List<VideoGame> findByPegi(int pegi) {
        return videoGameRepository.findAllByPegiEquals(pegi);
    }

    public void addVideoGame(VideoGame videoGame) {
        videoGameRepository.save(videoGame);
    }

    public void deleteById(Long id) {
        videoGameRepository.deleteById(id);
    }

    public void updateVideoGame(VideoGame videoGame) {
        Optional<VideoGame> optionalVideoGame = videoGameRepository.findById((videoGame.getId()));

        if (optionalVideoGame.isPresent()) {
            VideoGame updatedVideoGame = optionalVideoGame.get();

            if (videoGame.getTitle() != null) {
                updatedVideoGame.setTitle(videoGame.getTitle());
            }

            if (videoGame.getGenre() != null) {
                updatedVideoGame.setGenre(videoGame.getGenre());
            }

            if (videoGame.getPlatform() != null) {
                updatedVideoGame.setPlatform(videoGame.getPlatform());
            }

            if (videoGame.getPublisher() != null) {
                updatedVideoGame.setPublisher(videoGame.getPublisher());
            }

            if (videoGame.getPegi() != null) {
                updatedVideoGame.setPegi(videoGame.getPegi());
            }

            videoGameRepository.save(updatedVideoGame);
        }
    }

}
