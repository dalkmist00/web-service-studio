package com.studio.app.dynamo;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {
    @Value("${amazon.dynamodb.region}")
    private String amazonDynamoRegion;

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoEndpoint;

    @Value("${amazon.dynamodb.access.key}")
    private String amazonDynamoAccessKey;

    @Value("${amazon.dynamodb.secret.key}")
    private String amazonDynamoSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return getDynamoDBClient();
    }
    private AmazonDynamoDB getDynamoDBClient() {
        return AmazonDynamoDBClientBuilder.standard().withCredentials(getCredentialsProvider()).withEndpointConfiguration(getEndpointConfiguration()).build();
    }
    public AWSCredentialsProvider getCredentialsProvider() {
        AWSCredentials TEST_CREDENTIALS = new BasicAWSCredentials(amazonDynamoAccessKey, amazonDynamoSecretKey);
        return new AWSStaticCredentialsProvider(TEST_CREDENTIALS);
    }
    protected AwsClientBuilder.EndpointConfiguration getEndpointConfiguration() {
        return new AwsClientBuilder.EndpointConfiguration(amazonDynamoEndpoint, amazonDynamoRegion);
    }
}
