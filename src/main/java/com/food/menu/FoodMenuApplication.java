package com.food.menu;

import com.food.menu.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class FoodMenuApplication implements CommandLineRunner {

	@Autowired
	RecipeService recipeService;

	public static void main(String[] args) {

		SpringApplication.run(FoodMenuApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
//		recipeService.populateData();
//		recipeService.fetchData();
//		recipeService.deleteAll();
		recipeService.findOne();
	}

}
