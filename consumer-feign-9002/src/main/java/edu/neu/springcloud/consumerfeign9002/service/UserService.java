package edu.neu.springcloud.consumerfeign9002.service;

import edu.neu.springcloud.consumerfeign9002.config.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "provider", fallbackFactory = UserServiceFallbackFactory.class)
@Service
public interface UserService {
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    Object findAll();

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    Object findById(@PathVariable("id") int id);

    @RequestMapping(value = "/findAllByUsername/{userName}", method = RequestMethod.GET)
    Object findAllByUsername(@PathVariable("userName") String userName);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(MultiValueMap<String, Object> m);

    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    String modify(MultiValueMap<String, Object> m);

    @RequestMapping(value = "/delete?id={id}", method = RequestMethod.DELETE)
    String delete(@PathVariable int id);
}
