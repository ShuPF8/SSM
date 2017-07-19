package com.service;

import java.util.List;
import java.util.Map;

import com.utils.redis.RedisCacheStorage;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.UserEntity;
import com.mapper.UserMapper;
import com.utils.ResultJson;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final String  cacheKey  ="userPo";
	@Autowired UserMapper userMapper;
	@Autowired private RedisCacheStorage redisCacheStorage;
	public ResultJson save(UserEntity uPo){
		ResultJson r = new ResultJson();
		int n = userMapper.insert(uPo);
		if (n > 0){
			boolean flag = redisCacheStorage.hset(cacheKey, uPo.getId().toString(), uPo);
			r.setCode(200);
			r.setMaseege("成功");
		} else {
			r.setCode(400);
			r.setMaseege("失败");
		}
		return r;
	}
	
	public ResultJson findById(Integer id){
		ResultJson r = new ResultJson();
		Map<String, Object> map = null;
		map = (Map<String, Object>) redisCacheStorage.hget(cacheKey, id.toString());
		if (map == null) {
			map = userMapper.findById(id);
		}
		if (map == null || map.isEmpty()) {
			r.setCode(400);
			r.setMaseege("失败");
		} else {
			r.setCode(200);
			r.setMaseege("成功");
			r.setData(map);
		}
		return r;
	}
	
	public ResultJson findAll(){
		ResultJson r = new ResultJson();
		List<Map<String, Object>> list = userMapper.findAll();
		redisCacheStorage.set("list", list);
		if (list == null || list.isEmpty()) {
			r.setCode(400);
			r.setMaseege("失败");
		} else {
			r.setCode(200);
			r.setMaseege("成功");
			r.setDatas(list);
		}
		return r;
	}
}
