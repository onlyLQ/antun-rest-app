package com.qing.bigdata.antun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qing.bigdata.antun.domain.User;
import com.qing.bigdata.antun.domain.UserExample;
import com.qing.bigdata.antun.domain.UserExample.Criteria;
import com.qing.bigdata.antun.mapper.UserMapper;
import com.qing.bigdata.antun.util.TransferUtil;
import com.qing.bigdata.antun.web.model.UserAdd;
import com.qing.bigdata.antun.web.model.UserUpdate;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(null);
	}

	@Override
	public int addUser(UserAdd userAdd) {
		// TODO Auto-generated method stub
		//类转换(属性复制)
		User user =TransferUtil.transfer(userAdd, User.class);
		
		return userMapper.insertSelective(user);
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateUser(Long id, UserUpdate userUpdate) {
		// TODO Auto-generated method stub
		//类转换
		User user = TransferUtil.transfer(userUpdate, User.class);
		
		user.setId(id);
		
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int deleteUser(Long id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User findByPhone(String phone) {
		// TODO Auto-generated method stub
		//创建查询类对象
		UserExample userExample = new UserExample();
		
		Criteria createCriteria = userExample.createCriteria();
		//拼接查询参数
		createCriteria.andPhoneEqualTo(phone);
		
		List<User> selectByExample = userMapper.selectByExample(userExample);
				
		if(selectByExample.isEmpty())
					
			return null;
				
		return selectByExample.get(0);
	}

}
