package edu.neu.springcloud.consumerfeign9002.config;

import edu.neu.springcloud.consumerfeign9002.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {

            private String getMsg() {
                Pattern pattern = Pattern.compile("\"message\":\"(.*?)\",\"path\"");
                Matcher matcher = pattern.matcher(throwable.getMessage());
                String source = "";
                if (matcher.find())
                    source = matcher.group(1);
                return source;
            }

            @Override
            public Object findAll() {
                return getMsg();
            }

            @Override
            public Object findById(int id) {
                return getMsg();
            }

            @Override
            public Object findAllByUsername(String userName) {
                return getMsg();
            }

            @Override
            public String add(MultiValueMap<String, Object> m) {
                return getMsg();
            }

            @Override
            public String modify(MultiValueMap<String, Object> m) {
                return getMsg();
            }

            @Override
            public String delete(int id) {
                return getMsg();
            }
        };
    }
}
