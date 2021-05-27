package com.food.menu.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "recipes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipe {

    @Id
    private String id;

    @Field(name = "recipeName")
    @JsonProperty("TranslatedRecipeName")
    public String recipeName;

    @Field(name = "ingredients")
    @JsonProperty("TranslatedIngredients")
    public String ingredients;

    @Field
    @JsonProperty("PrepTimeInMins")
    public Long prepTimeInMins;

    @Field
    @JsonProperty("CookTimeInMins")
    public Long cookTimeInMins;

    @Field
    @JsonProperty("TotalTimeInMins")
    public Long totalTimeInMins;

    @Field
    @JsonProperty("Servings")
    public Long servings;

    @Field
    @JsonProperty("Cuisine")
    public String cuisine;

    @Field
    @JsonProperty("Course")
    public String course;

    @Field
    @JsonProperty("Diet")
    public String diet;

    @Field(name = "instructions")
    @JsonProperty("TranslatedInstructions")
    public String instructions;

    @Field
    @JsonProperty("URL")
    public String url;

}