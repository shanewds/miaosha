package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping("/get")
    @ResponseBody
    public UserVO getUser(@RequestParam(name="id") Integer id){
        System.out.println("=====id=="+id);
        //调用service服务获取对应Id的用户对象模型，用于处理业务
        UserModel userModel=userService.getUserById(id);
        //将核心领域模型用户对象转化为可供UI使用的viewobject
        return convertFromModel(userModel);

    }

    private UserVO convertFromModel(UserModel userModel){

        if (userModel == null){
            return null;
        }

        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }


}
