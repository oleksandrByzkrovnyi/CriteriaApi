package com.example.education.criteria.controllers;


import com.example.education.criteria.domain.Position;
import com.example.education.criteria.domain.Staff;
import com.example.education.criteria.services.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    public static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StaffService staffService;

    @CrossOrigin
    @RequestMapping(value = "/getStaff/{firstName}/{lastName}",method = RequestMethod.GET)
    public Staff getStaff(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        return  staffService.findOneByFirstNameAndLastName(firstName, lastName);
    }

    @CrossOrigin
    @RequestMapping(value = "/getCountStaff/{idDept}",method = RequestMethod.GET)
    public Long getCountStaff(@PathVariable("idDept") String idDept){
        return  staffService.getCountStaffInDept(Integer.parseInt(idDept));
    }

    @CrossOrigin
    @RequestMapping(value = "/getStaffsByPos/{position}",method = RequestMethod.GET)
    public List<Staff> getStaffOnPosition(@PathVariable("position") String position){
        return  staffService.findStaffOnPosition(Position.values()[Integer.parseInt(position)]);
    }

    @CrossOrigin
    @RequestMapping(value = "/getNameLike/{like}",method = RequestMethod.GET)
    public List<Staff> getStaffPartName(@PathVariable("like") String like){
        return  staffService.findStaffWhereNameHas("%"+like+"%");
    }

    @CrossOrigin
    @RequestMapping(value = "/getNameStart/{like}",method = RequestMethod.GET)
    public List<Staff> getStaffNameStart(@PathVariable("like") String like){
        return  staffService.findStaffWhereNameHas(like+"%");
    }

    @CrossOrigin
    @RequestMapping(value = "/getNameEnd/{like}",method = RequestMethod.GET)
    public List<Staff> getStaffNameEnd(@PathVariable("like") String like){
        return  staffService.findStaffWhereNameHas("%"+like);
    }

    @CrossOrigin
    @RequestMapping(value = "/getAvgDeptSal",method = RequestMethod.GET)
    public List<Object> getStaffNameEnd(){
        return  staffService.getAvgSalaryInDept();
    }

    @CrossOrigin
    @RequestMapping(value = "/updateName/{name}/{id}",method = RequestMethod.GET)
    public boolean updateName(@PathVariable("name") String name, @PathVariable("id") String id){
        return  staffService.updateStaff(name, Integer.parseInt(id));
    }
}
