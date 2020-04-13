package com.zlx.elasticsearch.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EsClient {


    public void createIndex() throws UnknownHostException {
        /**
         * 1 创建一个setting对象 相当于是一个配置信息 主要是设置集群名称
         */
        Settings settings = Settings.builder()
                .put("cluster.name","myes")
                .build();

        /**
         * 2 创建一个client客户端对象
         */
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new TransportAddress( InetAddress.getByName("heavens.tk"),9300));


        /**
         * 3 用管理员创建一个索引库
         */
        client
                //以管理员身份创建
                .admin().indices()
                //索引名称
                .prepareCreate("firstIndex")
                //执行创建
                .get();

        /**
         * 4 关闭客户端
         */
        client.close();
    }




    public void setMappings() throws UnknownHostException {
        //创建一个settings对象
        Settings settings = Settings.builder().put("cluster.name","myes").build();

        //创建一个TransPortClient对象
        TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName("heavens.tk"),9031));

    }
}
