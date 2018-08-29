package com.barterownia.service;

import com.barterownia.model.MusicAlbum;
import com.barterownia.model.VideoGame;
import com.barterownia.model.dto.NewMusicAlbumDTO;
import com.barterownia.repository.MusicAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MusicAlbumService {

    @Autowired
    private MusicAlbumRepository musicAlbumRepository;

    public void addAlbum(MusicAlbum musicAlbum) {
        musicAlbumRepository.save(musicAlbum);
    }

    public List<MusicAlbum> getAllAlbums() {
        return musicAlbumRepository.findAll();
    }

    public void deleteAlbum(Long id) {
        musicAlbumRepository.deleteById(id);
    }

    public List<MusicAlbum> findByBandName(String bandName) {
        return musicAlbumRepository.findAllByBandNameContaining(bandName);
    }

    public List<MusicAlbum> findByAlbumName(String albumName) {
        return musicAlbumRepository.findAllByAlbumNameContaining(albumName);
    }

    public Optional<MusicAlbum> findById(long id) {
        return musicAlbumRepository.findById(id);
    }

    public List<MusicAlbum> findByCarrier(String carrier) {
        return musicAlbumRepository.findAllByCarrier(carrier);
    }

    public void editAlbum(MusicAlbum musicAlbum) {
        Optional<MusicAlbum> optionalMusicAlbum = musicAlbumRepository.findById(musicAlbum.getId());

        if (optionalMusicAlbum.isPresent()) {
            MusicAlbum editMusicAlbum = optionalMusicAlbum.get();

            if (musicAlbum.getAlbumName() != null) {
                editMusicAlbum.setAlbumName(musicAlbum.getAlbumName());
            }

            if (musicAlbum.getBandName() != null) {
                editMusicAlbum.setBandName(musicAlbum.getBandName());
            }

            if (musicAlbum.getCarrier() != null) {
                editMusicAlbum.setCarrier(musicAlbum.getCarrier());
            }

            if (musicAlbum.getPublicationDate() != null) {
                editMusicAlbum.setPublicationDate(musicAlbum.getPublicationDate());
            }

            musicAlbumRepository.save(editMusicAlbum);
        }
    }

    public List<MusicAlbum> findByPublicationDateBetweenTwoDates(LocalDate min, LocalDate max) {
        return musicAlbumRepository.findAllByPublicationDateIsBetween(min, max);
    }

    public MusicAlbum addAlbum(NewMusicAlbumDTO musicAlbumDTO) {
    MusicAlbum musicAlbum = new MusicAlbum();
    musicAlbum.setAlbumName(musicAlbumDTO.getAlbumName());
    musicAlbum.setBandName(musicAlbumDTO.getBandName());
    musicAlbum.setCarrier(musicAlbumDTO.getCarrier());
    musicAlbum.setPublicationDate(musicAlbumDTO.getPublicationDate());

    return musicAlbumRepository.save(musicAlbum);
    }
}
