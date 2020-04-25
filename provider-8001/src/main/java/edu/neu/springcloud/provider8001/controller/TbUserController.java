package edu.neu.springcloud.provider8001.controller;

import edu.neu.springcloud.provider8001.bean.TbUserEntity;
import edu.neu.springcloud.provider8001.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TbUserController {
    @Autowired
    TbUserService tbUserService;

    @RequestMapping("/findById/{id}")
    public TbUserEntity findById(@PathVariable int id) throws Exception {
        return tbUserService.findById(id);
    }

    @RequestMapping("/findAll")
    public List<TbUserEntity> findAll() throws Exception {
        return tbUserService.findAll();
    }

    @RequestMapping("/findAllByUsername/{userName}")
    public List<TbUserEntity> findAllByUsername(@PathVariable String userName) throws Exception {
        return tbUserService.findAllByUsername(userName);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("id") int id, @RequestParam("loginName") String loginName, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("dbSource") String dbSource) throws Exception {
        System.out.println("add");
        TbUserEntity e = new TbUserEntity();
        e.setId(id);
        e.setLoginName(loginName);
        e.setUsername(username);
        e.setPassword(password);
        e.setSource(dbSource);
        return tbUserService.add(e);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") int id) throws Exception {
        System.out.println("delete");
        return tbUserService.delete(id);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public String modify(@RequestParam("id") int id, @RequestParam("loginName") String loginName, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("dbSource") String dbSource) throws Exception {
        System.out.println("modify");
        TbUserEntity e = new TbUserEntity();
        e.setId(id);
        e.setLoginName(loginName);
        e.setUsername(username);
        e.setPassword(password);
        e.setSource(dbSource);
        return tbUserService.modify(e);
    }
}
