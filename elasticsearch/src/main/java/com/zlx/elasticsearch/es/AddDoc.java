package com.zlx.elasticsearch.es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 添加文档
 */
public class AddDoc {
    public static void main(String[] args) throws IOException {
        Settings settings = Settings.builder().put("cluster.name","myes").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("jing.tk"),9300));

        //创建文档
        XContentBuilder doc = XContentFactory.jsonBuilder()
                .startObject()
                .field("id","1")
                .field("title","javase")
                .field("postdate","2020-04-11")
                .field("url","jing.tk")
                .endObject();

        //添加文档  先创建文档类型后添加 直接添加报错
        IndexResponse response = client.prepareIndex("index","blog","10").setSource(doc).get();

        //查看添加结果
        System.out.println(response.status());

        client.close();
    }
}
