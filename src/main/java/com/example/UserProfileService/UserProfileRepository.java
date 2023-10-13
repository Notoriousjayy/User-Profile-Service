package com.example.UserProfileService;

import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.Map;

@Repository
public class UserProfileRepository {
    private final DynamoDbClient dynamoDbClient;
    private final String tableName = "UserProfileTable"; // Replace with your table name

    public UserProfileRepository(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    public void createUserProfile(UserProfile userProfile) {
        Map<String, AttributeValue> item = /* Convert UserProfile to DynamoDB item format */;

        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();

        dynamoDbClient.putItem(request);
    }

    public UserProfile getUserProfile(String userId) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(tableName)
                .key(Map.of("userId", AttributeValue.builder().s(userId).build()))
                .build();

        GetItemResponse response = dynamoDbClient.getItem(request);

        if (response.hasItem()) {
            // Convert DynamoDB item to UserProfile
            return /* Convert DynamoDB item to UserProfile */;
        } else {
            return null;
        }
    }

    // Implement methods for updating and deleting user profiles
}

