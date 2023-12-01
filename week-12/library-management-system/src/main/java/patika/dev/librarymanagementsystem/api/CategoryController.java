package patika.dev.librarymanagementsystem.api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.librarymanagementsystem.business.abstracts.ICategoryService;
import patika.dev.librarymanagementsystem.core.config.IModelMapperService;
import patika.dev.librarymanagementsystem.core.result.Result;
import patika.dev.librarymanagementsystem.core.result.ResultData;
import patika.dev.librarymanagementsystem.core.utilies.ResultHelper;
import patika.dev.librarymanagementsystem.dto.request.category.CategorySaveRequest;
import patika.dev.librarymanagementsystem.dto.request.category.CategoryUpdateRequest;
import patika.dev.librarymanagementsystem.dto.response.CursorResponse;
import patika.dev.librarymanagementsystem.dto.response.category.CategoryResponse;
import patika.dev.librarymanagementsystem.entities.Book;
import patika.dev.librarymanagementsystem.entities.Category;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IModelMapperService modelMapper;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> get(@PathVariable("id") int id){
        Category category=this.categoryService.getById(id);
        CategoryResponse categoryResponse=this.modelMapper.forResponse().map(category,CategoryResponse.class);
        return ResultHelper.success(categoryResponse);
    }
   @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save (@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        Category saveCategory=this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        CategoryResponse categoryResponse= this.modelMapper.forResponse().map(saveCategory,CategoryResponse.class);
        return ResultHelper.created(categoryResponse);
    }

    @PutMapping("/{categoryId}/books/{bookId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Category assignBookToCategory(@PathVariable("categoryId") int categoryId,@PathVariable("bookId") int bookId){
        return this.categoryService.assignBookToCategory(categoryId,bookId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponse>> cursor(@RequestParam(name = "page",required = false,defaultValue = "0") int page, @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize){
        Page<Category> categoryPage=this.categoryService.cursor(page,pageSize);
        Page<CategoryResponse> categoryResponsePage=categoryPage
                .map(category -> this.modelMapper.forResponse().map(category,CategoryResponse.class));
        return ResultHelper.cursor(categoryResponsePage);
    }

    /*@PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> update (@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest){
       this.categoryService.getById(categoryUpdateRequest.getId());
        Category updateCategory=this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updateCategory);
        CategoryResponse categoryResponse= this.modelMapper.forResponse().map(updateCategory,CategoryResponse.class);
        return ResultHelper.success(categoryResponse);
    }*/

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
       if(this.categoryService.delete(id)){
           return ResultHelper.success();
       }
        return ResultHelper.error2();
    }
}
