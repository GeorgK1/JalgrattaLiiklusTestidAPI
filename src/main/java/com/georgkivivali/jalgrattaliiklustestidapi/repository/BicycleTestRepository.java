package com.georgkivivali.jalgrattaliiklustestidapi.repository;


import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.BicycleTest;
import com.georgkivivali.jalgrattaliiklustestidapi.bicycletest.TestCategories;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * This is the interface that speaks with the Mongodb instance running in the container
 */
public interface BicycleTestRepository extends MongoRepository<BicycleTest, String> {
    /**
     * Query method to find tests by category.
     * @param category category to query for
     * @return returns list of Bicycletests which matched the query.
     */
    List<BicycleTest> findBicycleTestByCategory(TestCategories category);
}
