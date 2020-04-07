package com.feding.kesimpl.admin.ums.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.feding.kesimpl.to.CommonResult;
import com.feding.kesimpl.ums.model.MemberLevel;
import com.feding.kesimpl.ums.service.MemberLevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberLevel")
@CrossOrigin
public class UmsMemberLevelController {
    private static final Logger log = LoggerFactory.getLogger(UmsMemberLevelController.class);
    @Reference
    private MemberLevelService memberLevelService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object memberLevelList(@RequestParam(value = "defaultStatus",defaultValue = "0") Long defaultStatus) {
        List<MemberLevel> result = memberLevelService.getMemberLevelByDefaultStatus(defaultStatus);
        return new CommonResult().success(result);
    }
}
