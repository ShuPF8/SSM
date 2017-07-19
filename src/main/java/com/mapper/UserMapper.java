package com.mapper;


import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserEntity>{

	Integer insert(@Param("user") UserEntity uPo);
	
	Map<String, Object> findById(@Param("id") int id);
	
	List<Map<String, Object>> findAll();
}
