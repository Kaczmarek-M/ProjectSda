package com.barterownia.controller;

import com.barterownia.model.VideoGame;
import com.barterownia.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
class TestVideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @RequestMapping(path = "/findAll")
    @ResponseBody
    public List<VideoGame> testFindAll() {
        return videoGameService.findAll();
    }

    @GetMapping(path = "/findById/{id}")
    @ResponseBody
    public Optional<VideoGame> testFindById(@PathVariable(name = "id") Long id) {
        return videoGameService.findByID(id);
    }

    @GetMapping(path = "/findByTitle/{title}")
    @ResponseBody
    public List<VideoGame> testFindByTitle(@PathVariable(name = "title") String title) {
        return videoGameService.findVideoGameByTitle(title);
    }

    @GetMapping(path = "/findByGenre/{genre}")
    @ResponseBody
    public List<VideoGame> testFindByGenre(@PathVariable(name = "genre") String genre) {
        return videoGameService.findByGenre(genre);
    }

    @GetMapping(path = "/findByPlatform/{platform}")
    @ResponseBody
    public List<VideoGame> testFindByPlatfrom(@PathVariable(name = "platform") String platform) {
        return videoGameService.findByPlatform(platform);
    }

    @GetMapping(path = "/findByPublisher/{publisher}")
    @ResponseBody
    public List<VideoGame> testFindByPublisher(@PathVariable(name = "publisher") String publisher) {
        return videoGameService.findByPublisher(publisher);
    }

    @RequestMapping
    @ResponseBody
    public List<VideoGame> testFindNew() {
        return videoGameService.findNew();
    }


    @RequestMapping(path = "/findUsed")
    @ResponseBody
    public List<VideoGame> testFindUsed() {
        return videoGameService.findUsed();
    }

    @RequestMapping(path = "/findByPegi/{pegi}")
    @ResponseBody
    public List<VideoGame> testFindByPegi(@PathVariable(name = "pegi") int pegi) {
        return videoGameService.findByPegi(pegi);
    }

}
