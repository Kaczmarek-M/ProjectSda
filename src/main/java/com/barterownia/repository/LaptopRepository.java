package com.barterownia.repository;

import com.barterownia.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    List<Laptop> findAllByNameContaining(String name);

    List<Laptop> findAllByMotherboard(String motherboard);

    List<Laptop> findAllByProcessor(String processor);

    List<Laptop> findAllByGraphicsCard(String graphicsCard);

    List<Laptop> findAllByHardDriveMbIsBetween(Long min, Long max);

    List<Laptop> findAllByRamMbIsBetween(Long min, Long max);

    List<Laptop> findAllByScreenSizeIsBetween(Float min, Float max);

    List<Laptop> findAllByIsNewIsFalse();

    List<Laptop> findAllByIsNewIsTrue();

    List<Laptop> findAllByIsWarrantyIsTrue();

    List<Laptop> findAllByDateOfProductionIsBetween(LocalDate min, LocalDate max);
 }
