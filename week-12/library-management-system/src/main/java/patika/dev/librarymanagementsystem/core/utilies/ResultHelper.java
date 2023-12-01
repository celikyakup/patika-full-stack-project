package patika.dev.librarymanagementsystem.core.utilies;

import org.springframework.data.domain.Page;
import patika.dev.librarymanagementsystem.core.result.Result;
import patika.dev.librarymanagementsystem.core.result.ResultData;
import patika.dev.librarymanagementsystem.dto.response.CursorResponse;
import patika.dev.librarymanagementsystem.dto.response.category.CategoryResponse;

public class ResultHelper {

    public static <T>ResultData<T> created(T data){
        return new ResultData<>(true,Message.CREATED,"201",data);
    }
    public static <T>ResultData<T> success(T data){
        return new ResultData<>(true,Message.OK,"200",data);
    }
    public static Result success(){
        return new Result(true,Message.OK,"200");
    }
    public static Result error(String message){
        return new Result(false,message,"404");
    }
    public static Result error2(){
        return new Result(false,Message.BOOK_VALUE,"400");
    }

    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursor=new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }
}
