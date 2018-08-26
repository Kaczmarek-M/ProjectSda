package com.barterownia.repository;

import com.barterownia.model.MobilePhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Long> {
    List<MobilePhone> findAllByNameContaining(String name);

    List<MobilePhone> findAllByIsNewIsTrue();

    List<MobilePhone> findAllByIsNewIsFalse();

    List<MobilePhone> findAllByIsWarrantyIsTrue();

    List<MobilePhone> findAllByColorContaining(String color);

    List<MobilePhone> findAllBySimlockContaining(String operator);

    List<MobilePhone> findAllByRamMbIsBetween(Long min, Long max);

    List<MobilePhone> findAllByScreenSizeIsBetween(Float min, Float max);
}
