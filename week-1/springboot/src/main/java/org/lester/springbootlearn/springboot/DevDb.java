package org.lester.springbootlearn.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@ConditionalOnProperty(name = "deploy.env", havingValue = "development")
public class DevDb implements DB {

    public String getData() {
        return "Dev Data";
    }
}
