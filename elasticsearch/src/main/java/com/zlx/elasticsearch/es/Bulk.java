package com.zlx.elasticsearch.es;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;

/**
 * _bulk 批量添加
 */
public class Bulk {
    public static void main(String[] args) throws IOException {
        Settings settings = Settings.builder().put("cluster.name","myes").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("jing.tk"), 9300));

        BulkRequestBuilder requestBuilder = client.prepareBulk();
        requestBuilder.add(
                client.prepareIndex("index2","book","9")
                .setSource(
                        XContentFactory.jsonBuilder()
                        .startObject()
                        .field("id","1")
                        .field("name","哈利波特")
                        .field("price","free")
                        .endObject()
                ));

        requestBuilder.add(
                client.prepareIndex("index2","book","8")
                        .setSource(
                                XContentFactory.jsonBuilder()
                                        .startObject()
                                        .field("id","3")
                                        .field("name","maoerhuo")
                                        .field("price","12")
                                        .endObject()
                        ));

        BulkResponse responses = requestBuilder.get();
        System.out.println(responses.status());
    }
}
