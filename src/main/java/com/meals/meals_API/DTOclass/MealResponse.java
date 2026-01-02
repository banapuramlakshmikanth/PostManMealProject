package com.meals.meals_API.DTOclass;

import java.util.List;

public class MealResponse {

    private List<Dto> meals;
    public List<Dto> getMeals(){
        return meals;
    }
    public void setMeals(List<Dto> Meals){
        this.meals = Meals;
    }
}
