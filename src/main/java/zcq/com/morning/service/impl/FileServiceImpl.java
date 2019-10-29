package zcq.com.morning.service.impl;

import org.springframework.stereotype.Service;
import zcq.com.morning.annotation.PrintLog;
import zcq.com.morning.service.FileService;

/**
 * @author zhengchuqin
 * @version 1.0
 * @since 2019/09/30
 */
@Service
@PrintLog(desc = "rrr")
public class FileServiceImpl implements FileService {
    @Override
    @PrintLog(desc = "t")
    public String copyFile(String url, String target) {
        System.out.println("url = "+url);
        System.out.println("target = " + target);
        return url + target;
    }
}
