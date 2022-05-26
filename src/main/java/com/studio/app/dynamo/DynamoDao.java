package com.studio.app.dynamo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.studio.app.dynamo.model.PersistentObject;

@org.springframework.stereotype.Repository
public class DynamoDao {
	@Autowired
    AmazonDynamoDB client;
	
    DynamoDBMapper mapper;

    @Value("${spring.dynamo.tablename}")
    private String tableName;

    @PostConstruct
    public void init() {
        DynamoDBMapperConfig mapperConfig = new DynamoDBMapperConfig.Builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(tableName))
                .build();
        mapper= new DynamoDBMapper(client, mapperConfig);
    }
    
    public PersistentObject load(PersistentObject po) {
    	return mapper.load(PersistentObject.class,po.getPk(),po.getSk());
    }
    
    public void save(PersistentObject po) {
    	mapper.save(po);
    }
}
