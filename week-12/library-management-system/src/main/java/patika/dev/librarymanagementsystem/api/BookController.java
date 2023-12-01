package patika.dev.librarymanagementsystem.api;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.librarymanagementsystem.business.abstracts.*;
import patika.dev.librarymanagementsystem.core.config.IModelMapperService;
import patika.dev.librarymanagementsystem.core.result.Result;
import patika.dev.librarymanagementsystem.core.result.ResultData;
import patika.dev.librarymanagementsystem.core.utilies.ResultHelper;
import patika.dev.librarymanagementsystem.dto.request.book.BookSaveRequest;
import patika.dev.librarymanagementsystem.dto.request.category.CategorySaveRequest;
import patika.dev.librarymanagementsystem.dto.response.book.BookResponse;
import patika.dev.librarymanagementsystem.dto.response.category.CategoryResponse;
import patika.dev.librarymanagementsystem.entities.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    private IModelMapperService modelMapper;
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private IPublisherService publisherService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save (@Valid @RequestBody BookSaveRequest bookSaveRequest){
        Book saveBook=this.modelMapper.forRequest().map(bookSaveRequest, Book.class);
        Author author=this.authorService.getById(bookSaveRequest.getAuthor_Id());
        saveBook.setAuthor(author);
        Publisher publisher=this.publisherService.getById(bookSaveRequest.getPublisherId());
        saveBook.setPublisher(publisher);
        this.bookService.save(saveBook);
        BookResponse bookResponse= this.modelMapper.forResponse().map(saveBook,BookResponse.class);
        return ResultHelper.created(bookResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody BookResponse bookResponse){
        Book updateBook=this.bookService.getById(bookResponse.getId());
        updateBook.setName(bookResponse.getName());
        updateBook.setStock(bookResponse.getStock());
        updateBook.setPublicationYear(bookResponse.getPublicationYear());
        return this.bookService.uptade(updateBook);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.bookService.delete(id);
        return ResultHelper.success();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> getById(@PathVariable("id") int id){
        Book book=this.bookService.getById(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(book,BookResponse.class));
    }


}
