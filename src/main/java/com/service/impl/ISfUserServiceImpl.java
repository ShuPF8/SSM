package com.service.impl;

import com.entity.SfUser;
import com.mapper.SfUserMapper;
import com.service.ISfUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.ResultJson;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2017-07-06
 */
@Service
public class ISfUserServiceImpl extends ServiceImpl<SfUserMapper, SfUser> implements ISfUserService {
    public ResultJson save(SfUser s) {
        ResultJson result = new ResultJson();
        int n = baseMapper.insert(s);
        if (n > 0) {
            result.success();
        }
        return result;
    }
}
