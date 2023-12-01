package patika.dev.librarymanagementsystem.api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.librarymanagementsystem.business.abstracts.IAuthorService;
import patika.dev.librarymanagementsystem.core.result.Result;
import patika.dev.librarymanagementsystem.core.result.ResultData;
import patika.dev.librarymanagementsystem.core.utilies.ResultHelper;
import patika.dev.librarymanagementsystem.dto.response.CursorResponse;
import patika.dev.librarymanagementsystem.entities.Author;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<Author> save(@Valid @RequestBody Author author){
        this.authorService.save(author);
        return ResultHelper.created(author);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<Author> update(@Valid @RequestBody Author author){
        this.authorService.getById(author.getId());
        this.authorService.update(author);
        return ResultHelper.success(author);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete (@PathVariable("id") int id){
        this.authorService.getById(id);
        this.authorService.delete(id);
        return ResultHelper.success();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<Author> get(@PathVariable("id") int id){
        Author author=this.authorService.getById(id);
        return ResultHelper.success(author);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<Author>> cursor(@RequestParam(name = "page",required = false,defaultValue = "0") int page, @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize){
        Page<Author> authorPage=this.authorService.cursor(page,pageSize);
        return ResultHelper.cursor(authorPage);
    }


}
