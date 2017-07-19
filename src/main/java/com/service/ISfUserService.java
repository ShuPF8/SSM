package com.service;

import com.entity.SfUser;
import com.baomidou.mybatisplus.service.IService;
import com.utils.ResultJson;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yanghu
 * @since 2017-07-06
 */
public interface ISfUserService extends IService<SfUser> {

    ResultJson save(SfUser s);

}
