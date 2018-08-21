package com.barterownia.controller;

import com.barterownia.model.MobilePhone;
import com.barterownia.service.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class TestMobilePhoneController {

    @Autowired
    private MobilePhoneService mobilePhoneService;

    @RequestMapping(path = "/findAll")
    @ResponseBody
    public List<MobilePhone> testFindAll() {
        return mobilePhoneService.findAll();
    }

    @GetMapping(path = "/findById/{id}")
    @ResponseBody
    public Optional<MobilePhone> testFindById(@PathVariable(name = "id") Long id) {
        return mobilePhoneService.findById(id);
    }

    @GetMapping(path = "/findByName/{name}")
    @ResponseBody
    public List<MobilePhone> testFindAllByName(@PathVariable(name = "name") String name) {
        return mobilePhoneService.findByNameContainingString(name);
    }

    @RequestMapping(path = "/findNew")
    @ResponseBody
    public List<MobilePhone> testFindNew() {
        return mobilePhoneService.findNew();
    }

    @RequestMapping(path = "/findUsed")
    @ResponseBody
    public List<MobilePhone> testFindUsed() {
        return mobilePhoneService.findUsed();
    }

    @RequestMapping(path = "/findWithWarranty")
    @ResponseBody
    public List<MobilePhone> testFindWithWarranty() {
        return mobilePhoneService.findWithWarranty();
    }

    @GetMapping(path = "/findByColor/{color}")
    @ResponseBody
    public List<MobilePhone> testFindByColor(@PathVariable(name = "color") String color) {
        return mobilePhoneService.findByColor(color);
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        mobilePhoneService.deleteById(id);
        return "redirect:/findAll";
    }

    @GetMapping(path = "/ram/{min}/{max}")
    @ResponseBody
    public List<MobilePhone> testFindByRam(@PathVariable(name = "min") Long min,
                                           @PathVariable(name = "max") Long max) {
        return mobilePhoneService.findByRamGreaterThanAndLessThan(min, max);
    }

    @GetMapping(path = "/findBySimlock/{operator}")
    @ResponseBody
    public List<MobilePhone> testFindBySimlock(@PathVariable(name = "operator") String operator) {
        return mobilePhoneService.findBySimlock(operator);
    }

    @GetMapping(path = "/screen/{min}/{max}")
    @ResponseBody
    public List<MobilePhone> testFindByScreen(@PathVariable(name = "min") Float min,
                                              @PathVariable(name = "max") Float max) {
        return mobilePhoneService.findByScreenSizeBiggerThanAndSmallerThan(min, max);
    }

    @GetMapping(path = "/update/{id}/{name}/{simlock}")
    public String testUpdateMobilePhone(@PathVariable(name = "id") Long id,
                                        @PathVariable(name = "name") String name,
                                        @PathVariable(name = "simlock") String simlock) {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setId(id);
        mobilePhone.setName(name);
        mobilePhone.setSimlock(simlock);
        mobilePhoneService.updateMobilePhone(mobilePhone);
        return "redirect:/findById/" + id;
    }
}
