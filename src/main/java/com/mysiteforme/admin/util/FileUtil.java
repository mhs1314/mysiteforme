package com.mysiteforme.admin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileUtil {

    @Value("${http.upload.url}")
    public static String url="http://132.232.87.134:9091/app/fileserver/upload";
    @Value("${http.down.url}")
    public static String down="http://132.232.87.134:9091/app/fileserver/";
    public static JSONObject upload(File file) {
        JSONObject jsonObject=null;
        String result ="";
        PostMethod filePost = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            // 通过以下方法可以模拟页面参数提交
            Part[] parts = {new FilePart("file", file)};
            filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
            client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);

            int status = client.executeMethod(filePost);
            if (status == HttpStatus.SC_OK) {
                        try {
                            result = filePost.getResponseBodyAsString();
                            jsonObject = JSON.parseObject(result);
                            if(!"200".equals(jsonObject.getString("code")) || jsonObject.getJSONObject("data").getString("url")==null){
                                throw new Exception("api上传失败");
                            }else{
                                System.out.println("上传成功" + result);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                }
            } else {
                System.out.println("上传失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            filePost.releaseConnection();
        }
        return jsonObject;
    }
}
