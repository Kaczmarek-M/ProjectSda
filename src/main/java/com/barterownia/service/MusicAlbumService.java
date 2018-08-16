package com.barterownia.service;

import com.barterownia.model.MusicAlbum;
import com.barterownia.repository.MusicAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicAlbumService {

    @Autowired
    private MusicAlbumRepository musicAlbumRepository;

    public void addAlbum(MusicAlbum musicAlbum){
        musicAlbumRepository.save(musicAlbum);
    }

    public List<MusicAlbum> getAllAlbums(){
        return musicAlbumRepository.findAll();
    }

    public void deleteAlbum(Long id){
        musicAlbumRepository.deleteById(id);
    }

    public List<MusicAlbum> findByBandName(String bandName){
        return musicAlbumRepository.findAlbumByBand(bandName);
    }

    public List<MusicAlbum> findByAlbumName(String albumName){
        return musicAlbumRepository.findAlbumByName(albumName);
    }

    public List<MusicAlbum> findByCarrier (String carrier){
        return musicAlbumRepository.findAlbumByCarrier(carrier);
    }

}
