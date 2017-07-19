package com.service;

import com.entity.UserRecordEntity;
import com.mapper.UserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author SPF
 * @Date 2017/5/2
 */
@Component
public class UserRecordService {

    @Autowired
    private UserRecordMapper userRecordMapper;

    public int insert(UserRecordEntity userRecord) {
        return userRecordMapper.insert(userRecord);
    }

}
