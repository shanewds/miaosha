package com.miaoshaproject;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

/**
 * Hello world!
 *
 */
//使用该注解，会自动启动一个tomcat运行在后台端口号8080
//@EnableAutoConfiguration
//扫描根目录下的包
@SpringBootApplication(scanBasePackages ={"com.miaoshaproject"})
@RestController
//扫描dao的包
@MapperScan("com.miaoshaproject.dao")
public class App 
{


    @Autowired
    private UserDOMapper userDOMapper;


    //测试 访问数据库执行查询
    @RequestMapping("/")
    public Object home(){

        UserDO userDO=userDOMapper.selectByPrimaryKey(1);
        if (userDO == null){
            return  "用户对象不存在";
        }
        return userDO.getName();
    }




    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }




}
