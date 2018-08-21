package com.barterownia.repository;

import com.barterownia.model.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {
/*
TODO CRUD methods
public void addGame(VideoGame videoGame);
public void deleteGame(long id);
public void editGame(long id, VideoGame videoGame);
*/

    List<VideoGame> findVideoGameByTitle(String title);

    List<VideoGame> findByPlatform(String platform);

    List<VideoGame> findByGenre(String genre);

    List<VideoGame> findByPrice(long min, long max);

    List<VideoGame> findNew(boolean yes);

    List<VideoGame> findUsed(boolean no);

    List<VideoGame> findByPegi(int pegi);

}
