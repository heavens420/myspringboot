package com.zlx.elasticsearch.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 删除文档
 */
public class Delete {
    public static void main(String[] args) throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name","myes").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("jing.tk"), 9300));

        //删除索引下含 name含有  哈利  的文档
        BulkByScrollResponse bulkByScrollResponse = DeleteByQueryAction.INSTANCE
                .newRequestBuilder(client)
                .source("index2")
                .filter(QueryBuilders.matchQuery(
                        "name","哈利"
                )).get();

        long count = bulkByScrollResponse.getDeleted();
        System.out.println(count);
    }
}
