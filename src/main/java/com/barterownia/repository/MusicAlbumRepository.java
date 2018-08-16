package com.barterownia.repository;

import com.barterownia.model.MusicAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicAlbumRepository extends JpaRepository<MusicAlbum, Long> {

    List<MusicAlbum> findAlbumByBand(String bandName);

    List<MusicAlbum> findAlbumByName(String albumName);

    List<MusicAlbum> findAlbumByCarrier(String carrier);
}
