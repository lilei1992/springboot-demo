package com.fsd.fsdaop;

import com.fsd.fsdaop.aop.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FsdAopApplication.class)
public class FsdAopApplicationTests {
    @Autowired
    Person person;

    /**
     * 测试aop
     */
    @Test
    public void contextLoads() {
        person.say();
    }

}
