package com.czp.demo.Controller;

import com.czp.demo.Model.BjUser;
import com.czp.demo.Service.BjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BjUserController {
    @Autowired
    private BjUserService bjUserService;

    @RequestMapping("/users")
    public String getUserList(){
        List<BjUser> list = bjUserService.selectPeople();
        return list.toString();
    }
}
