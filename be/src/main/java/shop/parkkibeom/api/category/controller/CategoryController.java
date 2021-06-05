package shop.parkkibeom.api.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.parkkibeom.api.category.domain.CategoryDTO;
import shop.parkkibeom.api.category.service.CategoryServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping("/list")
    public ResponseEntity<List<CategoryDTO>> list() {
        return ResponseEntity.ok(categoryService.getCategoryList());
    }
}
