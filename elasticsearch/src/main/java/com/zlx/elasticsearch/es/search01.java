package com.zlx.elasticsearch.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 查询索引
 */

public class search01 {
    public static void main(String[] args) throws UnknownHostException {

        //指定集群 （myes)
        Settings settings = Settings.builder().put("cluster.name","myes").build();

        //创建连接
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("jing.tk"),9300));

        //查询索引
        GetResponse response = client.prepareGet("lib","user","1").execute().actionGet();

        client.close();
        //打印索引信息
        System.out.println(response.getSourceAsString());
//        System.out.println("jkkk");
    }
}
