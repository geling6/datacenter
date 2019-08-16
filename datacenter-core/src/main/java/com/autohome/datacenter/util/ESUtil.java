package com.autohome.datacenter.util;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author: houxuesong
 * @date: 2019-06-05 09:36
 **/
@Component
public class ESUtil {

    private static RestHighLevelClient client = null;

    private static String esHosts;

    private final static Header headers = new BasicHeader("content-type", "application/json");

    @Value("${spring.elasticsearch.host}")
    public void setEsHosts(String esHosts) {
        ESUtil.esHosts = esHosts;
    }

    /**
     * 初始化client客户端
     */
    private static RestHighLevelClient getClient() {
        if (null != client) {
            return client;
        }
        String[] esHostArray = esHosts.split(",");

        if (esHostArray != null) {
            HttpHost[] hosts = new HttpHost[esHostArray.length];
            for (int i = 0; i < esHostArray.length; i++) {
                String esHost = esHostArray[i];
                String[] hostPort = esHost.split(":");
                HttpHost host = new HttpHost(hostPort[0], Integer.valueOf(hostPort[1]), "http");
                hosts[i] = host;
            }
        	/*Settings settings =
        			Settings.builder().put("client.transport.sniff", true).put("cluster.name", clusterName).build();*/

            client = new RestHighLevelClient(RestClient.builder(hosts));

        }
        return client;
    }

    /**
     * 新建索引
     */
    public static boolean createIndex(XContentBuilder builder, Settings settings, String index, String type) throws IOException {

        CreateIndexRequest request = new CreateIndexRequest(index);
        request.settings(settings);
        request.mapping(type, builder);

        CreateIndexResponse response = getClient().indices().create(request, headers);

        return response.isAcknowledged();
    }

    /**
     * 删除索引
     */
    public static boolean deleteIndex(String index) throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest();
        deleteIndexRequest.indices(index);
        DeleteIndexResponse resposne = getClient().indices().delete(deleteIndexRequest, headers);
        return true;
    }

    /**
     * 单条插入
     */
    public static boolean insert(String index, String type, String esId, String docJson) throws Exception {
        IndexRequest indexRequest = new IndexRequest(index, type, esId);
        indexRequest.source(docJson, XContentType.JSON);
        IndexResponse response = getClient().index(indexRequest, headers);

        return true;
    }


    /**
     * @author houxueong
     * @date 2018-12-07 19:00
     * @desc 批量插入es
     */
    public static void insertBatch(String index, String type, List<String> docJson) throws IOException {

        BulkRequest bulkRequest = new BulkRequest();

        int count = 0;
        for (int i = 0; i < docJson.size(); i++) {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            IndexRequest indexRequest = new IndexRequest(index, type, uuid);
            String s = docJson.get(i);
//            JSONObject dataAsJson = JsonUtil.convertString2Obj(s, JSONObject.class);
//            HashMap<String, Object> dataAsMap = new HashMap<String, Object>(dataAsJson);
            indexRequest.source(s, XContentType.JSON);
            bulkRequest.add(indexRequest);
            count++;
            if (count % 500 == 0) {
                getClient().bulk(bulkRequest, headers);
                count = 0;
            }
        }
        if (count != 0) {
            getClient().bulk(bulkRequest, headers);
        }
    }

    /**
     * 修改数据
     */
    public static boolean update(String index, String type, String id, String docJson) throws IOException {
        UpdateRequest updateRequest = new UpdateRequest(index, type, id);
        updateRequest.doc(docJson, XContentType.JSON);
        updateRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        UpdateResponse response = getClient().update(updateRequest, headers);

        return true;
    }

    /**
     * 删除数据
     */
    public static boolean delete(String index, String type, String esId) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index, type, esId);

        DeleteResponse response = getClient().delete(deleteRequest, headers);

        return true;

    }

    /**
     * 查询方法
     */
    public static SearchResponse search(String index, QueryBuilder query, Integer from, Integer pageSize,
                                        List<SortBuilder> sortBuilderList, String... types) throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        //设置索引
        searchRequest.indices(index);
        //设置查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(query);
        //设置分页
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(pageSize);
        //设置排序
        if (!CollectionUtils.isEmpty(sortBuilderList)) {
            for (SortBuilder sortBuilder : sortBuilderList) {
                searchSourceBuilder.sort(sortBuilder);
            }
        }
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = getClient().search(searchRequest);

        return searchResponse;
    }

    /**
     * 按索引查
     */
    public static GetResponse getById(String index, String type, String id) throws IOException {

        GetRequest getRequest = new GetRequest(index, type, id);
        return getClient().get(getRequest, headers);
    }

}
