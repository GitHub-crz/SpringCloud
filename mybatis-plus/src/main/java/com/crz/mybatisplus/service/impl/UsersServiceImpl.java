package com.crz.mybatisplus.service.impl;

import com.crz.mybatisplus.entity.Users;
import com.crz.mybatisplus.mapper.UsersMapper;
import com.crz.mybatisplus.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rzcai
 * @since 2022-04-01
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
