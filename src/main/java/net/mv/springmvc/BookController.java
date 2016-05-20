package net.mv.springmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping(value = "/getBook", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Book> getBook() {

		Book book = new Book();
		book.setTitle("Git in Practice");
		book.setIsbn(123456789101l);
		book.setAuthor("McQuaid");

		if(book != null){
			throw new RuntimeException("oops!");
		}
		
		return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/addBook", consumes = {})
	public ResponseEntity<Book> addBook(Book book) {
		System.out.println(book);

		return new ResponseEntity<Book>(HttpStatus.CONFLICT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> handleExceptions(Exception ex) {
		return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}