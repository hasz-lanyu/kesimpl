package com.feding.kesimpl.oms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.oms.mapper.CompanyAddressMapper;
import com.feding.kesimpl.oms.model.CompanyAddress;
import com.feding.kesimpl.oms.service.CompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 公司收发货地址表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class CompanyAddressServiceImpl extends ServiceImpl<CompanyAddressMapper, CompanyAddress> implements CompanyAddressService {
    @Autowired
    private CompanyAddressMapper companyAddressMapper;
    @Override
    public List<CompanyAddress> getCompanyAddressList() {
        return companyAddressMapper.selectList(null);
    }
}
