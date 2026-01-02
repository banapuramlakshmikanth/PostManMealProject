package com.meals.meals_API.Serviceclass;

import com.meals.meals_API.DTOclass.Dto;
import com.meals.meals_API.DTOclass.MealAnalysisResponseDTO;
import com.meals.meals_API.DTOclass.MealResponse;
import com.meals.meals_API.DTOclass.MealSummaryDTO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@org.springframework.stereotype.Service
public class MealService {

    private MealAnalysisResponseDTO latestResult;

    public MealAnalysisResponseDTO analyzeMeals(MealResponse mealResponse) {

        if (mealResponse == null || mealResponse.getMeals() == null) {
            latestResult = new MealAnalysisResponseDTO(new ArrayList<>(), null);
            return latestResult;
        }

        List<MealSummaryDTO> summaries = new ArrayList<>();

        for (Dto meal : mealResponse.getMeals()) {

            List<String> ingredients = extractIngredients(meal);

            MealSummaryDTO summary = new MealSummaryDTO();
            summary.setIngredients(ingredients);
            summary.setIngredientCount(ingredients.size());
            summary.setLeastIngredientMeal(false);

            summaries.add(summary);
        }

        MealSummaryDTO leastIngredientMeal =
                summaries.stream()
                        .min(Comparator.comparingInt(MealSummaryDTO::getIngredientCount))
                        .orElse(null);

        if (leastIngredientMeal != null) {
            leastIngredientMeal.setLeastIngredientMeal(true);
        }

        latestResult = new MealAnalysisResponseDTO(summaries, leastIngredientMeal);

        return latestResult;
    }

    public MealAnalysisResponseDTO getLatestResult() {
        if (latestResult == null) {
            return new MealAnalysisResponseDTO(
                new ArrayList<>(),
                null
            );
        }
        return latestResult;
    }


    private List<String> extractIngredients(Dto meal) {

        List<String> ingredients = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            try {
                Field field = Dto.class.getDeclaredField("strIngredient" + i);
                field.setAccessible(true);
                String value = (String) field.get(meal);

                if (value != null && !value.trim().isEmpty()) {
                    ingredients.add(value.trim());
                }
            } catch (Exception ignored) {
            }
        }
        return ingredients;
    }
}
