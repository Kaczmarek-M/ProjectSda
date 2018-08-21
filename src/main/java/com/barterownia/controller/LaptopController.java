package com.barterownia.controller;

import com.barterownia.model.Laptop;
import com.barterownia.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @RequestMapping(path = "/findAll")
    @ResponseBody
    public List<Laptop> findAll() {
        return laptopService.findAll();
    }

    @GetMapping(path = "/findById/{id}")
    @ResponseBody
    public Optional<Laptop> findById(@PathVariable(name = "id") Long id) {
        return laptopService.findById(id);
    }

    @GetMapping(path = "/findByName/{name}")
    @ResponseBody
    public List<Laptop> findByName(@PathVariable(name = "name") String name) {
        return laptopService.findAllByNameContainingString(name);
    }

    @RequestMapping(path = "/findNew")
    @ResponseBody
    public List<Laptop> findNew() {
        return laptopService.findNew();
    }

    @RequestMapping(path = "/findUsed")
    @ResponseBody
    public List<Laptop> findUsed() {
        return laptopService.findUsed();
    }

    @RequestMapping(path = "/findWithWarranty")
    @ResponseBody
    public List<Laptop> findWithWarranty() {
        return laptopService.findWithWarranty();
    }

    @GetMapping(path = "/findByProcessor/{processor}")
    @ResponseBody
    public List<Laptop> findProcessor(@PathVariable(name = "processor") String processor) {
        return laptopService.findByProcessor(processor);
    }

    @GetMapping(path = "/findByMotherboard/{motherboard")
    @ResponseBody
    public List<Laptop> findMotherboard(@PathVariable(name = "motherboard") String motherboard) {
        return laptopService.findByMotherboard(motherboard);
    }

    @GetMapping(path = "/findByGraphicsCard/{graphicsCard")
    @ResponseBody
    public List<Laptop> findGraphicsCard(@PathVariable(name = "graphicsCard") String graphicsCard) {
        return laptopService.findByGraphicsCard(graphicsCard);
    }

    @GetMapping(path = "/screen/{min}/{max}")
    @ResponseBody
    public List<Laptop> findByScreenSize(@PathVariable(name = "min") Float min,
                                         @PathVariable(name = "max") Float max) {
        return laptopService.findByScreenSizeBiggerThanAndSmallerThan(min, max);
    }

    @GetMapping(path = "/ramMb/{min}/{max}")
    @ResponseBody
    public List<Laptop> findByRam(@PathVariable(name = "min") Long min,
                                  @PathVariable(name = "max") Long max) {
        return laptopService.findByRamGreaterThanAndLessThan(min, max);
    }

    @GetMapping(path = "/hardDriveMb/{min}/{max}")
    @ResponseBody
    public List<Laptop> findByHardDrive(@PathVariable(name = "min") Long min,
                                        @PathVariable(name = "max") Long max) {
        return laptopService.findByHardDriveGreaterThanAndLessThan(min, max);
    }

    @GetMapping(path = "/dateOfProduction/{min}/{max}")
    @ResponseBody
    public List<Laptop> findByDateOfProduction(@PathVariable(name = "min") LocalDate min,
                                               @PathVariable(name = "max") LocalDate max) {
        return laptopService.findByDateOfProductionGreaterThanAndLessThan(min, max);
    }
}
