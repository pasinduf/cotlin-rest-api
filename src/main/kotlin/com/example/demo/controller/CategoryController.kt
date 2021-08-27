package com.example.demo.controller

import com.example.demo.model.Category
import com.example.demo.repository.CategoryRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/category")
class CategoryController(val categoryRepository: CategoryRepository){

    @GetMapping
    fun getCategoryList() = categoryRepository.findAll();

    @RequestMapping(path = [("/{id}")],method = [(RequestMethod.GET)])
    fun getCategory(@PathVariable("id") id:Long):Optional<Category>?{
        return  categoryRepository.findById(id);
    }

    @PostMapping
    fun createCategory(@RequestBody category: Category):Category{
        var result=categoryRepository.save(category);
        return  result;
    }

    @RequestMapping(path = [("/{id}")],method = [(RequestMethod.PUT)])
    fun updateCategory(@PathVariable("id") id:Long,@RequestBody category: Category):Category?{
        var exist= categoryRepository.findById(id);
        if(exist !==null){
            var result= categoryRepository.save(category);
            return  result;
        }
        return  null;
    }

    @RequestMapping(path = [("/{id}")],method = [(RequestMethod.DELETE)])
    fun deleteCategory(@PathVariable("id") id:Long){
          categoryRepository.deleteById(id);
    }


}