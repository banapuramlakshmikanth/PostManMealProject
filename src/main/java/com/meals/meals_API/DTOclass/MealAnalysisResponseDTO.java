package com.meals.meals_API.DTOclass;

import java.util.List;

public class MealAnalysisResponseDTO {

    private List<MealSummaryDTO> allMeals;
    private MealSummaryDTO leastIngredientMeal;

    
    public MealAnalysisResponseDTO() {
    }

    public MealAnalysisResponseDTO(List<MealSummaryDTO> allMeals,
                                   MealSummaryDTO leastIngredientMeal) {
        this.allMeals = allMeals;
        this.leastIngredientMeal = leastIngredientMeal;
    }

    public List<MealSummaryDTO> getAllMeals() {
        return allMeals;
    }

    public void setAllMeals(List<MealSummaryDTO> allMeals) {
        this.allMeals = allMeals;
    }

    public MealSummaryDTO getLeastIngredientMeal() {
        return leastIngredientMeal;
    }

    public void setLeastIngredientMeal(MealSummaryDTO leastIngredientMeal) {
        this.leastIngredientMeal = leastIngredientMeal;
    }
}
