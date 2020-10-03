package com.ma.bb.service.edu.feign;

import com.ma.bb.common.base.result.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author biaob
 * @date 2020/10/02
 */
@FeignClient("service-oss")
@Component
public interface OssFileService {

    /**
     * 测试微服务之间调用
     * @return
     */
    @GetMapping("/admin/oss/file/test")
    R test();

    /**
     * 删除文件
     * @param url 文件的url地址
     * @return
     */
    @DeleteMapping("/admin/oss/file/remove")
    R removeFile(@RequestBody String url);

}
