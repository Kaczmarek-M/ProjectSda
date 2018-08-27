package com.barterownia.service;


import com.barterownia.model.Auction;
import com.barterownia.model.Category;
import com.barterownia.model.Item;
import com.barterownia.model.Laptop;
import com.barterownia.model.dto.NewLaptopDTO;
import com.barterownia.repository.AuctionRepository;
import com.barterownia.repository.CategoryRepository;
import com.barterownia.repository.ItemRepository;
import com.barterownia.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();}

    public Laptop addLaptop(NewLaptopDTO newLaptopDTO) {

        Laptop laptop = new Laptop();
        laptop.setName(newLaptopDTO.getName());
        laptop.setProcessor(newLaptopDTO.getProcessor());
        laptop.setHardDriveMb(newLaptopDTO.getHardDriveMb());
        laptop.setRamMb(newLaptopDTO.getRamMb());
        laptop.setScreenSize(newLaptopDTO.getScreenSize());
        laptop.setMotherboard(newLaptopDTO.getMotherboard());
        laptop.setGraphicsCard(newLaptopDTO.getGraphicsCard());
        laptop.setDateOfProduction(newLaptopDTO.getDateOfProduction());
        laptop.setIsNew(newLaptopDTO.getIsNew());
        laptop.setIsWarranty(newLaptopDTO.getIsWarranty());

        return laptopRepository.save(laptop);
    }
    public void deleteById(Long id){
        laptopRepository.deleteById(id);
    }
    public Optional<Laptop> findById (Long id){
        return laptopRepository.findById(id);
    }
    public List<Laptop> findAllByNameContainingString(String name){
        return laptopRepository.findAllByNameContaining(name);
    }
    public List<Laptop> findByDateOfProductionGreaterThanAndLessThan(LocalDate min, LocalDate max){
        return laptopRepository.findAllByDateOfProductionIsBetween(min, max);
    }
    public List<Laptop> findNew(){
        return laptopRepository.findAllByIsNewIsTrue();
    }
    public List<Laptop> findUsed(){
        return laptopRepository.findAllByIsNewIsFalse();
    }
    public List<Laptop> findWithWarranty(){
        return laptopRepository.findAllByIsWarrantyIsTrue();
    }
    public List<Laptop> findByRamGreaterThanAndLessThan(Long ramMin, Long ramMax){
        return laptopRepository.findAllByRamMbIsBetween(ramMin, ramMax);
    }
    public List<Laptop> findByHardDriveGreaterThanAndLessThan(Long min, Long max){
        return laptopRepository.findAllByHardDriveMbIsBetween(min, max);
    }
    public List<Laptop> findByGraphicsCard(String name){
        return laptopRepository.findAllByGraphicsCard(name);
    }
    public List<Laptop> findByProcessor(String name){
        return laptopRepository.findAllByProcessor(name);
    }
    public List<Laptop> findByMotherboard(String name){
        return laptopRepository.findAllByMotherboard(name);
    }
    public List<Laptop> findByScreenSizeBiggerThanAndSmallerThan(Float min, Float max){
        return laptopRepository.findAllByScreenSizeIsBetween(min, max);
    }
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    public void updateLaptop(Laptop laptop){
        Optional<Laptop> optionalLaptop = laptopRepository.findById(laptop.getId());

        if (optionalLaptop.isPresent()) {

            Laptop updateLaptop = optionalLaptop.get();
            if (laptop.getName() != null){
                updateLaptop.setName(laptop.getName());
            }
            if (laptop.getProcessor() != null){
                updateLaptop.setProcessor(laptop.getProcessor());
            }
            if (laptop.getMotherboard() != null){
                updateLaptop.setMotherboard(laptop.getMotherboard());
            }
            if (laptop.getGraphicsCard() != null){
                updateLaptop.setGraphicsCard(laptop.getGraphicsCard());
            }
            if (laptop.getHardDriveMb() != null){
                updateLaptop.setRamMb(laptop.getRamMb());
            }
            if (laptop.getHardDriveMb() != null){
                updateLaptop.setHardDriveMb(laptop.getHardDriveMb());
            }
            if (laptop.getIsNew() !=null){
                updateLaptop.setIsNew(laptop.getIsNew());
            }
            if (laptop.getIsWarranty() != null){
                updateLaptop.setIsWarranty(laptop.getIsWarranty());
            }
            if (laptop.getScreenSize() != null){
                updateLaptop.setScreenSize(laptop.getScreenSize());
            }
            if (laptop.getDateOfProduction() != null){
                updateLaptop.setDateOfProduction(laptop.getDateOfProduction());
            }
            laptopRepository.save(updateLaptop);
        }
    }

    public Optional<Laptop> getLaptopWithId(Long laptopId) {
        return laptopRepository.findById(laptopId);
    }

}
