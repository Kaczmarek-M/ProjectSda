package com.barterownia.repository;

import com.barterownia.model.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    List<VideoGame> findAllByTitleContaining (String title);

    List<VideoGame> findAllByGenreContaining(String genre);

    List<VideoGame> findAllByPlatformContaining(String platform);

    List<VideoGame> findAllByPublisherContaining(String publisher);

    List<VideoGame> findAllByIsNewIsFalse();

    List<VideoGame> findAllByIsNewIsTrue();

    List<VideoGame> findAllByPegiContaining(int pegi);

}
