package com.zlx.elasticsearch.es;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutionException;

/**
 * upsert() 存在更新 不存在创建
 */
public class UpSert {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Settings settings = Settings.builder().put("cluster.name","myes").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("jing.tk"),9300));

        IndexRequest indexRequest = new IndexRequest("index","blog","7")
                .source(
                        XContentFactory.jsonBuilder()
                        .startObject()
                        .field("id","3")
                        .field("title","golang")
                        .field("postdate","2020-09-09")
                        .field("url","heavens.tk")
                        .endObject()
                );
        UpdateRequest updateRequest = new UpdateRequest("index","blog","7")
                .doc(
                        XContentFactory.jsonBuilder()
                        .startObject()
                        .field("title","go")
                        .endObject()
                ).upsert(indexRequest);
        UpdateResponse response = client.update(updateRequest).get();
        System.out.println(response.status());
        client.close();
    }
}
