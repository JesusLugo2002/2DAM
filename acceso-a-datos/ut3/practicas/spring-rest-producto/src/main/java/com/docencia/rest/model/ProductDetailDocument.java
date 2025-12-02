package com.docencia.rest.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product_detail")
public class ProductDetailDocument {

    @Id
    private int id;

    private int productId;

    private String description;

    private Map<String, String> technicalSpecifications;

    private List<String> tags;

}
