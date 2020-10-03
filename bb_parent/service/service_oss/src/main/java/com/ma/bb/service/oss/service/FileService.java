package com.ma.bb.service.oss.service;

import java.io.InputStream;

/**
 * @author biaob
 * @date 2020/10/02
 */
public interface FileService {
    /**
     * 阿里云文件上传
     * @param inputStream 输入流
     * @param module 文件夹名称
     * @param originalFilename 原始文件名
     * @return 文件在oss服务器上的url地址
     */
    String upload(InputStream inputStream, String module, String originalFilename);


    /**
     * 阿里云文件删除
     * @param url 文件的URL地址
     */
    void removeFile(String url);
}
