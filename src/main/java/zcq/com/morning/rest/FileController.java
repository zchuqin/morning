package zcq.com.morning.rest;
/**
 * ***************************************************************************
 * Copyright (C) 2017 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 * ****************************************************************************
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zcq.com.morning.annotation.PrintLog;
import zcq.com.morning.service.FileService;

/**
 * @author zhengchuqin
 * @version 1.0
 * @since 2019/09/30
 */
@Controller
@RequestMapping("/file")
@Api("文件")
public class FileController {

    @Autowired
    FileService fileService;

    @ResponseBody
    @GetMapping("/test")
    @ApiOperation(value = "test",notes = "test")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "url", value = "url", required = true, dataType = "string", defaultValue = "2834"),
            @ApiImplicitParam(paramType = "query",name = "target", value = "target", required = true, dataType = "string", defaultValue = "trey")
    })
    public String test(String url, String target) {
        return fileService.copyFile(url,target);
    }
}
