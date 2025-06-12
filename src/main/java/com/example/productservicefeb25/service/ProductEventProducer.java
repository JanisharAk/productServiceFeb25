package com.example.productservicefeb25.service;



import com.example.productservicefeb25.dto.ProductEventDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public ProductEventProducer(KafkaTemplate<String, String> kafkaTemplate,
                                ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendProductEvent(ProductEventDto event) throws JsonProcessingException {
        String jsonMessage = objectMapper.writeValueAsString(event);
        kafkaTemplate.send("productEvents", jsonMessage);
    }
}