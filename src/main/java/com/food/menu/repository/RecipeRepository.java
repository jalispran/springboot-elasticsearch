package com.food.menu.repository;

import com.food.menu.document.Recipe;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RecipeRepository extends ElasticsearchRepository<Recipe, String> {


}
