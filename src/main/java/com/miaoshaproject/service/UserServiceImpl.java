package com.miaoshaproject.service;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dao.UserPasswordDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import com.miaoshaproject.dataobject.UserPasswordDO;
import com.miaoshaproject.service.model.UserModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
       //调用userdomapper获取到对应的用户dataobject
       UserDO userDO = userDOMapper.selectByPrimaryKey(id);
       //返回给前端应该是model 由于表的拆分需要一个密码的返回
        if (userDO == null){
            return null;
        }
        //通过用户id获取对应的用户加密密码信息,需要手动书写mapper
        UserPasswordDO userPasswordDO=userPasswordDOMapper.selectByUserId(userDO.getId());

        return convertFromDataObject(userDO,userPasswordDO);

    }

     private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO){

           if (userDO == null){
               return null;
           }
           UserModel userModel=new UserModel();
           BeanUtils.copyProperties(userDO,userModel);
           if (userPasswordDO !=null){
               //只需要一个属性，单独设置值
               userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
           }

           return  userModel;


     }





}
