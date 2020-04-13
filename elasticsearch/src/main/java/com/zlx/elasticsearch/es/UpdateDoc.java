package com.zlx.elasticsearch.es;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

/**
 * 更新文档
 */
public class UpdateDoc {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Settings settings = Settings.builder().put("cluster.name", "myes").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("jing.tk"), 9300));

        UpdateRequest request = new UpdateRequest();
        request.index("index")
                .type("blog")
                .id("10")
                .doc(
                        XContentFactory.jsonBuilder().startObject()
                        .field("title","python")
                        .endObject()
                );
        UpdateResponse response = client.update(request).get();
    }
}
