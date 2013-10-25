package north.sample.spark.book;

import com.avaje.ebean.Ebean;
import north.sample.domain.Book;
import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;

public class PostBookRoute extends JsonTransformer {

    public PostBookRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        Book book = new Book();
        book.setTitle(request.queryParams("title"));
        book.setAuthor(request.queryParams("author"));
        Ebean.save(book);
        response.status(201); // 201 Created
        return book;
    }
    
}
