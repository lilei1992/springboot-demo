package com.fsd.mybatis;

import com.fsd.mybatis.util.DBUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FsdMybatisApplicationTests {




    @Test
    public void testDbConnection(){
        DBUtils.getConnection();
    }

}
