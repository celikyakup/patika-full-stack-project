package patika.dev.librarymanagementsystem.api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.librarymanagementsystem.business.abstracts.IBookBorrowingService;
import patika.dev.librarymanagementsystem.business.abstracts.IBookService;
import patika.dev.librarymanagementsystem.core.config.IModelMapperService;
import patika.dev.librarymanagementsystem.core.result.Result;
import patika.dev.librarymanagementsystem.core.result.ResultData;
import patika.dev.librarymanagementsystem.core.utilies.ResultHelper;
import patika.dev.librarymanagementsystem.dto.request.bookBorrowing.BookBorrowingSaveRequest;
import patika.dev.librarymanagementsystem.dto.request.bookBorrowing.BookBorrowingUpdateRequest;
import patika.dev.librarymanagementsystem.dto.response.CursorResponse;
import patika.dev.librarymanagementsystem.dto.response.bookBorrowing.BookBorrowingResponse;
import patika.dev.librarymanagementsystem.entities.Book;
import patika.dev.librarymanagementsystem.entities.BookBorrowing;

@RestController
@RequestMapping("/v1/book-borrowings")
public class BookBorrowingController {
    @Autowired
    private IBookBorrowingService bookBorrowingService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IModelMapperService modelMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowingResponse> save (@Valid @RequestBody BookBorrowingSaveRequest borrowingSaveRequestS){
        BookBorrowing saveBorrowing=this.modelMapper.forRequest().map(borrowingSaveRequestS, BookBorrowing.class);
        Book book=this.bookService.getById(borrowingSaveRequestS.getBook_id());
        saveBorrowing.setBook(book);
        this.bookBorrowingService.save(saveBorrowing);
        BookBorrowingResponse borrowingResponse= this.modelMapper.forResponse().map(saveBorrowing,BookBorrowingResponse.class);
        return ResultHelper.created(borrowingResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> update (@Valid @RequestBody BookBorrowingUpdateRequest borrowingUpdateRequest){
        this.bookBorrowingService.getById(borrowingUpdateRequest.getId());
        BookBorrowing updateBorrowing=this.modelMapper.forRequest().map(borrowingUpdateRequest, BookBorrowing.class);
        if (this.bookBorrowingService.update(updateBorrowing)!=null ){
            BookBorrowingResponse borrowingResponse= this.modelMapper.forResponse().map(updateBorrowing,BookBorrowingResponse.class);
            return ResultHelper.success(borrowingResponse);
        }
        return (ResultData<BookBorrowingResponse>) ResultHelper.error("Kitap stoğu olmadığı için kayıt yapılamıyor.");
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> get(@PathVariable("id") int id){
        BookBorrowing borrowing=this.bookBorrowingService.getById(id);
        BookBorrowingResponse borrowingResponse=this.modelMapper.forResponse().map(borrowing,BookBorrowingResponse.class);
        return ResultHelper.success(borrowingResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookBorrowingResponse>> cursor(@RequestParam(name = "page",required = false,defaultValue = "0") int page, @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize){
        Page<BookBorrowing> borrowingPage=this.bookBorrowingService.cursor(page,pageSize);
        Page<BookBorrowingResponse> borrowingResponsePage=borrowingPage
                .map(bookBorrowing -> this.modelMapper.forResponse().map(bookBorrowing,BookBorrowingResponse.class));
        return ResultHelper.cursor(borrowingResponsePage);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.bookBorrowingService.delete(id);
        return ResultHelper.success();
    }

}
