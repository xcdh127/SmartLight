package com.light.demo.mqtt;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class CreateTopicRouteTable {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tFgMMH79BxAMmBviEDC", "n6AOtslCXct6b7ngivng6bPx8GzlyD");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("iot.cn-shanghai.aliyuncs.com");
        request.setSysVersion("2018-01-20");
        request.setSysAction("CreateTopicRouteTable");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("SrcTopic", "/sys/h84sWr7GXZw/aa22/thing/service/property/set");
        request.putQueryParameter("DstTopic.1", "/sys/h84sWr7GXZw/mzh001/thing/service/property/set");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
