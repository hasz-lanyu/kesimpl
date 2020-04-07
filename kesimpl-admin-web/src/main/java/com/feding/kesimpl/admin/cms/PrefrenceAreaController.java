package com.feding.kesimpl.admin.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.feding.kesimpl.cms.model.PrefrenceArea;
import com.feding.kesimpl.cms.service.PrefrenceAreaService;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/prefrenceArea")
public class PrefrenceAreaController {
    private static final Logger log = LoggerFactory.getLogger(PrefrenceAreaController.class);

    @Reference
    private PrefrenceAreaService prefrenceAreaService;
    @RequestMapping(value = "/listAll" ,method = RequestMethod.GET)
    public Object prefrenceAreaList(){
        try {
            List<PrefrenceArea> prefrenceAreas=prefrenceAreaService.getPrefrenceAreaList();
            return new CommonResult().success(prefrenceAreas);
        } catch (Exception e) {
            log.error("数据查询失败：{}",PrefrenceAreaController.class);
        }
        return  CommonResult.FAILED;
    }
}
