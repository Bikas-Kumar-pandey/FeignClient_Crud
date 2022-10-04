package com.feig.feignUtil;

import com.feig.controller.dto.CategoryRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Act as layer to interact with External Api's
@FeignClient(value = "feignDemo", url = "http://localhost:9090/test") //Junit_Test_Bosch
public interface FeignServiceUtil {
    @GetMapping
    public List<CategoryRequest> readValue();

    @GetMapping("/{id}")
    public String readValueById(@PathVariable int id);

    @PostMapping
    public String createCategoryInDifferentApp(CategoryRequest categoryRequest);

    @PutMapping
    public String updateCategory(CategoryRequest categoryRequest);

    @DeleteMapping("{id}")
    String deleteById(@PathVariable int id);
}

