package com.feding.kesimpl.admin.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.feding.kesimpl.cms.model.Subject;
import com.feding.kesimpl.cms.service.SubjectService;
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
@RequestMapping("/subject")
public class SubjectController {
    private static final Logger log = LoggerFactory.getLogger(SubjectController.class);

    @Reference
    private SubjectService subjectService;

    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public Object subjectList() {
        try {
            List<Subject> subjects= subjectService.getSubjectList();
            return new CommonResult().success(subjects);
        } catch (Exception e) {
            log.error("数据查询异常");
        }
        return CommonResult.FAILED;
    }
}
