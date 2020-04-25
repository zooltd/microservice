package edu.neu.springcloud.consumerribbon9001.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class UserController {
    private static final String REST_URL_PREFIX = "http://provider";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/findAll")
    @HystrixCommand(fallbackMethod = "findAllFallback")
    public Object findAll() {
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(REST_URL_PREFIX + "/findAll", Object.class);
        return responseEntity.getBody();
    }

    public Object findAllFallback(Throwable throwable) {
        return getMsg(throwable);
    }

    @RequestMapping("/findById/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public Object findById(@PathVariable int id) {
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(REST_URL_PREFIX + "/findById/" + id, Object.class);
        return responseEntity.getBody();
    }

    public Object findByIdFallback(int id, Throwable throwable) {
        return getMsg(throwable);
    }

    @RequestMapping("/findAllByUsername/{userName}")
    @HystrixCommand(fallbackMethod = "findAllByUsernameFallback")
    public Object findAllByUsername(@PathVariable String userName) {
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(REST_URL_PREFIX + "/findAllByUsername/" + userName, Object.class);
        return responseEntity.getBody();
    }

    public Object findAllByUsernameFallback(String userName, Throwable throwable) {
        return getMsg(throwable);
    }

    @RequestMapping("/add")
    @HystrixCommand(fallbackMethod = "transactionFallback")
    public Object add() {
        LinkedMultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
        dataMap.add("id", "20");
        dataMap.add("loginName", "add");
        dataMap.add("username", "add");
        dataMap.add("password", "add");
        dataMap.add("dbSource", "mybatis");
        restTemplate.postForEntity(REST_URL_PREFIX + "/add", dataMap, String.class);
        return "Add success.";
    }

    @RequestMapping("/modify")
    @HystrixCommand(fallbackMethod = "transactionFallback")
    public Object modify() {
        LinkedMultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
        dataMap.add("id", "20");
        dataMap.add("loginName", "modify");
        dataMap.add("username", "modify");
        dataMap.add("password", "modify");
        dataMap.add("dbSource", "mybatis");
        restTemplate.put(REST_URL_PREFIX + "/modify", dataMap);
        return "Modify success.";
    }


    @RequestMapping(value = "/delete")
    @HystrixCommand(fallbackMethod = "transactionFallback")
    public Object deleteByUsernameAndPassword() {
        Object[] data = {20};
        restTemplate.delete(REST_URL_PREFIX + "/delete?id={0}", data);
        return "Delete success.";
    }

    public Object transactionFallback(Throwable throwable) {
        return getMsg(throwable);
    }

    public Object getMsg(Throwable throwable) {
        Pattern pattern = Pattern.compile("\"message\":\"(.*?)\",\"path\"");
        Matcher matcher = pattern.matcher(throwable.getMessage());
        String msg = "";
        if (matcher.find())
            msg = matcher.group(1);
        return msg;
    }
}
