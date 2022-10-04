package com.feig.controller;

import com.feig.controller.dto.CategoryRequest;
import com.feig.feignUtil.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private FeignServiceUtil feignServiceUtil;

    @GetMapping
    public List<CategoryRequest> readSingleData() {
        return feignServiceUtil.readValue();
    }

    @GetMapping("/{id}")
    public String readById(@PathVariable int id) {
        return feignServiceUtil.readValueById(id);
    }

    @PostMapping
    public String createCategoryInDifferentApp(@RequestBody CategoryRequest categoryRequest){
        return feignServiceUtil.createCategoryInDifferentApp(categoryRequest);
    }
@PutMapping
    public String updateCategory(@RequestBody CategoryRequest categoryRequest){
        return feignServiceUtil.updateCategory(categoryRequest);
}

@DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
       return feignServiceUtil.deleteById(id);
}

}
