package com.ads.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ads.dao.IUserMapper;
import com.ads.model.UserModel;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	private static final Integer pageNo = 1;
	private static final Integer size = 10;

	@Autowired
	private IUserMapper iUserMapper;

	@Transactional(propagation = Propagation.REQUIRED)
	public void addUser(UserModel user) throws SQLException {
//		iUserMapper.addOne(user);
//		int a= 1/0;
		iUserMapper.addOne(user);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Map<String, Object> findList() throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PageHelper.startPage(pageNo, size, true);
			Page<UserModel> users = iUserMapper.findList();
			if (null != users && users.size() > 0) {
				logger.info("获取商品信息:{}", users);
				map.put("content", users);
				map.put("total", users.getTotal());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取用户列表错误");
			throw e;
		}
		return map;
	}

}
