package com.georgkivivali.jalgrattaliiklustestidapi.controller;

import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.BicycleTest;
import com.georgkivivali.jalgrattaliiklustestidapi.service.BicycleTestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 This is the controller that handles HTTP requests to the API.
 */
@RestController
@RequestMapping("/api/v1/bicycletests")
@AllArgsConstructor
public class JalgrattaLiiklusTestidController {

    private final BicycleTestService bicycleTestService;

    @GetMapping
    public List<BicycleTest> fetchAllBicycleTests() {
        return bicycleTestService.getAllBicycleTests();
    }

    @PostMapping
    public void registerNewBicycleTest(@RequestBody BicycleTest bicycleTest) {bicycleTestService.addNewBicycleTest(bicycleTest);}
}
