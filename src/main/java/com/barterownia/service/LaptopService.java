package com.barterownia.service;


import com.barterownia.model.Laptop;
import com.barterownia.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;

@Service
public class LaptopService {

    @Autowired

    private LaptopRepository laptopRepository;

    public void addLaptop (Laptop laptop) {laptopRepository.save(laptop); }

    public List <Laptop> getAllLaptops() {return laptopRepository.findAll(); }

    public void deleteLaptop(Long id) {laptopRepository.deleteById(id);}

    public List<Laptop> findByName (String name){
        return laptopRepository.findAllByName(name);
    }

    public List<Laptop> findByMotherboard (String motherBoard){
        return laptopRepository.findAllByMotherboard(motherBoard);
    }

    public List<Laptop> findByProcessor (String processor){
        return laptopRepository.findAllByProcessor(processor);
    }

    public List<Laptop> findByHardDrive (String hardDrive){
        return laptopRepository.findAllByHardDrive(hardDrive);
    }

    public List<Laptop> findByRam (String ram){
        return laptopRepository.findAllByRAM(ram);
    }

    public List<Laptop> findByGraphicsCard (String graphicsCard){
        return laptopRepository.findAllByGraphicsCard(graphicsCard);
    }
}
