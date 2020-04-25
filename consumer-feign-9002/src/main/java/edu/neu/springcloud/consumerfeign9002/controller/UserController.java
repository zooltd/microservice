package edu.neu.springcloud.consumerfeign9002.controller;

import edu.neu.springcloud.consumerfeign9002.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public Object findAll() {
        return userService.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Object findUserById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @RequestMapping("findAllByUsername/{userName}")
    public Object findAllByUsername(@PathVariable("userName") String userName) {
        return userService.findAllByUsername(userName);
    }

    @RequestMapping("/add")
    public Object add() {
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
        dataMap.add("id", "20");
        dataMap.add("loginName", "add");
        dataMap.add("username", "add");
        dataMap.add("password", "add");
        dataMap.add("dbSource", "mybatis");
        return userService.add(dataMap);
    }

    @RequestMapping("/modify")
    public Object modify() {
        LinkedMultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
        dataMap.add("id", "20");
        dataMap.add("loginName", "modify");
        dataMap.add("username", "modify");
        dataMap.add("password", "modify");
        dataMap.add("dbSource", "mybatis");
        return userService.modify(dataMap);
    }


    @RequestMapping(value = "/delete")
    public Object deleteByUsernameAndPassword() {
        return userService.delete(20);
    }
}
