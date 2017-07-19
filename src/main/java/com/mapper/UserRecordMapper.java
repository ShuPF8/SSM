package com.mapper;

import com.entity.UserRecordEntity;

public interface UserRecordMapper {
    int deleteById(Integer id);

    int insert(UserRecordEntity record);

    int insertSelective(UserRecordEntity record);

    UserRecordEntity selectFindById(Integer id);

    int updateAllById(UserRecordEntity record);

    int updateById(UserRecordEntity record);
}