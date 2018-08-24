package com.barterownia.repository;

import com.barterownia.model.MusicAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MusicAlbumRepository extends JpaRepository<MusicAlbum, Long> {

    List<MusicAlbum> findAllByBandNameContaining(String bandName);

    List<MusicAlbum> findAllByAlbumNameContaining(String albumName);

    List<MusicAlbum> findAllByCarrier(String carrier);

    List<MusicAlbum> findAllByPublicationDateIsBetween(LocalDate min, LocalDate max);
}
