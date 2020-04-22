package com.zlx.elasticsearch.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * _mget 批量查询
 */
public class Mget {
    public static void main(String[] args) throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name","myes").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("jing.tk"), 9300));

        MultiGetResponse responses = client.prepareMultiGet()
                .add("lib","user","2","1","3")
                .add("index","blog","8","7")
                .get();

//        for (MultiGetItemResponse re:responses
//             ) {
//            GetResponse getResponse = re.getResponse();
//            if (getResponse.isExists() && getResponse != null) {
//                System.out.println(getResponse.getSourceAsString());
//            }
//        }
        responses.forEach((re)-> System.out.println(re.getResponse().getSourceAsString()));
    }
}
