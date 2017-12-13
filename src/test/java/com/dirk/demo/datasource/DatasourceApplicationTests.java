package com.dirk.demo.datasource;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dirk.demo.datasource.h2.entity.Book;
import com.dirk.demo.datasource.h2.repository.BookRepository;
import com.dirk.demo.datasource.mysql.entity.User;
import com.dirk.demo.datasource.mysql.repository.UserRepositry;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceApplicationTests {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepositry userRepository;
	
	public void contextLoads() {
	}
	
	@Test
	public void testFindAllBook() {
		List<Book> bookList = bookRepository.findAll();
		bookList.forEach(System.out::println);
	}
	
	@Test
	public void addBook() {
		Book book = new Book();
		book.setId(4L);
		book.setName("Spring in Action");
		book.setPrice(47.49);
		bookRepository.save(book);
		testFindAllBook();
	}
	
	@Test
	@Transactional
	public void testAddUser() {
		User user = new User();
		user.setName("小A");
		user.setAge(18);
		userRepository.save(user);
	}
	
	@Test
	public void findAllUser() {
		List<User> userList = userRepository.findAll();
		userList.forEach(System.out::println);
	}
}
