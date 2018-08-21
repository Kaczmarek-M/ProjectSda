package com.barterownia.repository;

import com.barterownia.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    List<Laptop> findAllByName(String name);

    List<Laptop> findAllByMotherboard(String motherboard);

    List<Laptop> findAllByProcessor(String processor);

    List<Laptop> findAllByHardDrive(String hardDrive);

    List<Laptop> findAllByRAM(String ram);

    List<Laptop> findAllByGraphicsCard(String graphicsCard);
}
