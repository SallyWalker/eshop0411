package com.me.usermanage.service.impl;

import com.me.usermanage.bean.UserInfo;
import com.me.usermanage.mapper.UserMapper;
import com.me.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserInfo> getUserInfoListAll() {
        List<UserInfo> userInfoList = userMapper.selectAll();
        return userInfoList;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        //Selective是只插入需要插入的列
        userMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        //Selective是如果有空值就不修改
        userMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name", name);
        userMapper.updateByExampleSelective(userInfo, example);
    }

    @Override
    public void delUser(UserInfo userInfo) {
        userMapper.delete(userInfo);
    }

    @Override
    public UserInfo getUserInfo(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
