package com.meals.meals_API.DTOclass;



import java.util.List;

public class MealSummaryDTO {

    private String mealId;
    private String mealName;
    private int ingredientCount;
    private List<String> ingredients;
    private boolean leastIngredientMeal;

    public MealSummaryDTO() {
    }

    public MealSummaryDTO(String mealId, String mealName, int ingredientCount, List<String> ingredients, boolean leastIngredientMeal) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.ingredientCount = ingredientCount;
        this.ingredients = ingredients;
        this.leastIngredientMeal = leastIngredientMeal;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getIngredientCount() {
        return ingredientCount;
    }

    public void setIngredientCount(int ingredientCount) {
        this.ingredientCount = ingredientCount;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isLeastIngredientMeal() {
        return leastIngredientMeal;
    }

    public void setLeastIngredientMeal(boolean leastIngredientMeal) {
        this.leastIngredientMeal = leastIngredientMeal;
    }
}
