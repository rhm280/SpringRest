package net.mv.springmvc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BookMain {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		
		Book book = new Book();
		book.setTitle("Something");
		book.setIsbn(000000000l);
		book.setAuthor("Someone");
		
		try{
			rt.postForObject("http://localhost:8081/SpringRest/addBook", book, ResponseEntity.class);
		}catch (Exception ex){
			ex.printStackTrace();
		}		
	}
}