package com.meals.meals_API.Controllerclass;

import com.meals.meals_API.DTOclass.MealAnalysisResponseDTO;
import com.meals.meals_API.DTOclass.MealResponse;
import com.meals.meals_API.Serviceclass.MealService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/meals")
public class Controller {

    private final MealService service;

    public Controller(MealService service) {
        this.service = service;
    }

   
    @PostMapping("/analyze")
    public MealAnalysisResponseDTO analyzeMeals(@RequestBody MealResponse mealResponse) {
        return service.analyzeMeals(mealResponse);
    }

  
    @GetMapping("/latest")
    public MealAnalysisResponseDTO getLatestResult() {
        return service.getLatestResult();
    }
}
