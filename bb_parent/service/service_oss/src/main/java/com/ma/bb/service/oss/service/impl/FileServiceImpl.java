package com.ma.bb.service.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.ma.bb.service.oss.service.FileService;
import com.ma.bb.service.oss.util.OssProperties;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author biaob
 * @date 2020/10/02
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private OssProperties ossProperties;
    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        if (!ossClient.doesBucketExist(bucketname)){
            ossClient.createBucket(bucketname);
            ossClient.setBucketAcl(bucketname, CannedAccessControlList.PublicRead);
        }

        //构建objectName：文件路径
        String folder = new DateTime().toString("yyyy/MM/dd");
        String fileName = UUID.randomUUID().toString();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String key = module + "/" +folder + "/" + fileName+fileExtension;

        //上传文件流
        ossClient.putObject(bucketname, key, inputStream);

// 关闭OSSClient。
        ossClient.shutdown();

        //返回url
        return "https://"+bucketname+"."+endpoint+"/"+key;
    }

    @Override
    public void removeFile(String url) {
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();


        //创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);

        //删除文件
        String host = "https://" + bucketname + "." + endpoint + "/";
        String objectName = url.substring(host.length());
        ossClient.deleteObject(bucketname, objectName);


        //关闭OSSClient
        ossClient.shutdown();
    }
}
