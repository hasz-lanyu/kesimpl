package com.feding.kesimpl.ums.service.impl;

import com.feding.kesimpl.ums.model.Member;
import com.feding.kesimpl.ums.mapper.MemberMapper;
import com.feding.kesimpl.ums.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
