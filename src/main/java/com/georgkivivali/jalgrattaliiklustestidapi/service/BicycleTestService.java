package com.georgkivivali.jalgrattaliiklustestidapi.service;

import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.BicycleTest;
import com.georgkivivali.jalgrattaliiklustestidapi.repository.BicycleTestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class BicycleTestService {
    private final BicycleTestRepository repository;

    public List<BicycleTest> getAllBicycleTests() {
        return repository.findAll();
    }

    public void addNewBicycleTest(BicycleTest bicycleTest) {
        repository.save(bicycleTest);
    }
}
