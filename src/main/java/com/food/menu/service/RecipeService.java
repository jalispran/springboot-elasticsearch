package com.food.menu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.menu.document.Recipe;
import com.food.menu.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public void populateData() {
        Resource resource = new ClassPathResource("static/recipes.json");
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);

            List<Recipe> recipes = convertToPojo(data);
            log.info(String.valueOf(recipes.size()));
            for(int i=0; i<recipes.size(); i++) {
                recipes.get(i).setId(String.valueOf(i));
            }

            recipeRepository.saveAll(recipes);

        } catch (IOException e) {
            log.error("IOException", e);
        }
    }

    private List<Recipe> convertToPojo(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, new TypeReference<List<Recipe>>(){});
    }

    public void fetchData() {
        Iterable<Recipe> all = recipeRepository.findAll();
        all.iterator().forEachRemaining(recipe -> log.info("Recipe: {}", recipe));
    }

    public void findOne() {
        Optional<Recipe> byId = recipeRepository.findById("6870");
        log.info("By ID: {}", byId);
    }

    public void deleteAll() {
        recipeRepository.deleteAll();
    }
}
