package sxq.demo.manager;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sxq.demo.dao.UserDao;
import sxq.demo.mapper.UserMapper;
import sxq.demo.model.User;

@Component
public class UserManager {

	/*@Resource
	private UserMapper userMapper;
	
	@Transactional
	public void save(User user){
		this.userMapper.save(user);
	}
	
	public List<User> qeuryUserList(){
		List<User> list =  this.userMapper.queryByParams(new HashMap<String,Object>());
		return list;
	}*/
	@Resource
	private UserDao userDao;
	
	@Transactional
	public void save(User user){
		this.userDao.save(user);
	}
	
	public List<User> qeuryUserList(){
		List<User> list =  this.userDao.findAll();//.queryByParams(new HashMap<String,Object>());
		return list;
	}
	
}
