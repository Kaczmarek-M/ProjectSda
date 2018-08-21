package com.barterownia.service;

import com.barterownia.model.MobilePhone;
import com.barterownia.repository.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobilePhoneService {

    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    public Optional<MobilePhone> findById(Long id) {
        return mobilePhoneRepository.findById(id);
    }

    public List<MobilePhone> findByNameContainingString(String name) {
        return mobilePhoneRepository.findAllByNameContaining(name);
    }

    public List<MobilePhone> findNew() {
        return mobilePhoneRepository.findAllByIsNewIsTrue();
    }

    public List<MobilePhone> findUsed() {
        return mobilePhoneRepository.findAllByIsNewIsFalse();
    }

    public List<MobilePhone> findWithWarranty() {
        return mobilePhoneRepository.findAllByIsWarrantyIsTrue();
    }

    public List<MobilePhone> findByColor(String color) {
        return mobilePhoneRepository.findAllByColorContaining(color);
    }

    public void deleteById(Long id) {
        mobilePhoneRepository.deleteById(id);
    }

    public List<MobilePhone> findByRamGreaterThanAndLessThan(Long min, Long max) {
        return mobilePhoneRepository.findAllByRamIsBetween(min, max);
    }

    public List<MobilePhone> findAll() {
        return mobilePhoneRepository.findAll();
    }

    public List<MobilePhone> findBySimlock(String operator) {
        return mobilePhoneRepository.findAllBySimlockContaining(operator);
    }

    public List<MobilePhone> findByScreenSizeBiggerThanAndSmallerThan(Float min, Float max) {
        return mobilePhoneRepository.findAllByScreenSizeIsBetween(min, max);
    }

    public void addMobilePhone(MobilePhone mobilePhone) {
        mobilePhoneRepository.save(mobilePhone);
    }

    public void updateMobilePhone(MobilePhone mobilePhone) {
        Optional<MobilePhone> optionalMobilePhone = mobilePhoneRepository.findById(mobilePhone.getId());

        if (optionalMobilePhone.isPresent()) {

            MobilePhone updatedMobilePhone = optionalMobilePhone.get();

            if (mobilePhone.getName() != null) {
                updatedMobilePhone.setName(mobilePhone.getName());
            }
            if (mobilePhone.getProcessor() != null) {
                updatedMobilePhone.setIsNew(mobilePhone.getIsNew());
            }
            if (mobilePhone.getRam() != null) {
                updatedMobilePhone.setRam(mobilePhone.getRam());
            }
            if (mobilePhone.getScreenSize() != null) {
                updatedMobilePhone.setScreenSize(mobilePhone.getScreenSize());
            }
            if (mobilePhone.getSimlock() != null) {
                updatedMobilePhone.setSimlock(mobilePhone.getSimlock());
            }
            if (mobilePhone.getColor() != null) {
                updatedMobilePhone.setColor(mobilePhone.getColor());
            }
            if (mobilePhone.getIsNew() != null) {
                updatedMobilePhone.setIsNew(mobilePhone.getIsNew());
            }
            if (mobilePhone.getIsWarranty() != null) {
                updatedMobilePhone.setIsWarranty(mobilePhone.getIsWarranty());
            }
            if (mobilePhone.getWarranty() != null) {
                updatedMobilePhone.setWarranty(mobilePhone.getWarranty());
            }

            mobilePhoneRepository.save(updatedMobilePhone);
        }
    }
}
