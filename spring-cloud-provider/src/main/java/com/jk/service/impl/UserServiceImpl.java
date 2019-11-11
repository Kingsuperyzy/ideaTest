package com.jk.service.impl;/** * @program: spring_cloud_parent * @author: yzy * @create: 2019-11-06 21:50 **/import com.jk.mapper.UserModelMapper;import com.jk.model.UserModel;import com.jk.service.UsersService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.HashMap;import java.util.List;/** *@ClassName UserServiceImpl *@Author yzy *@Date 2019/11/6 21:50 */@Servicepublic class UserServiceImpl implements UsersService {    @Autowired    private UserModelMapper userModelMapper;    @Override    public HashMap<String, Object> initTable(Integer page, Integer rows) {        HashMap<String, Object> map = new HashMap<String, Object>();        Integer count = userModelMapper.queryUserCount();        Integer start = (page - 1) * rows;        List<UserModel> list = userModelMapper.queryUser(start, rows);        map.put("total", count);        map.put("rows", list);        return map;    }    @Override    public void addBook(UserModel u) {        userModelMapper.insert(u);    }    @Override    public UserModel queryUser(Integer id) {        UserModel userModel = userModelMapper.selectByPrimaryKey(id);        return userModel;    }    @Override    public void updateBook(UserModel u) {        userModelMapper.updateByPrimaryKey(u);    }    @Override    public UserModel getUser(String name) {        return userModelMapper.queryUser1(name);    }}