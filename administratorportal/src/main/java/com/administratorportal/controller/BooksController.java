package com.administratorportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.administratorportal.domain.Books;
import com.administratorportal.service.BooksService;

@Controller
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BooksService booksService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		Books books = new Books();
		model.addAttribute("books", books);
		return "addbooks";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addbooksPost(@ModelAttribute("books") Books books, HttpServletRequest request) {
		booksService.save(books);

		MultipartFile bookImage = books.getBookImage();

		try {
			byte[] bytes = bookImage.getBytes();
			String name = books.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:booksList";
	}
	
	@RequestMapping("/booksList")
	public String booksList(Model model) {
		List<Books> booksList = booksService.findAll();
		model.addAttribute("booksList", booksList);
		return "booksList";
		
	}

	@RequestMapping("/bookinfo")
	public String bookInfo(@RequestParam("id") Long id, Model model) {
		Books book = booksService.getOne(id);
		model.addAttribute("book", book);
		
		return "bookinfo";
	}
	
	@RequestMapping("/updatebook")
	public String updateBook(@RequestParam("id") Long id, Model model) {
		Books book = booksService.getOne(id);
		model.addAttribute("book", book);
		
		return "updatebook";
	}
	
	@RequestMapping(value="/updatebook", method=RequestMethod.POST)
	public String updateBookPost(@ModelAttribute("book") Books book, HttpServletRequest request) {
		booksService.save(book);
		
		MultipartFile bookImage = book.getBookImage();
		
		if(!bookImage.isEmpty()) {
			try {
				byte[] bytes = bookImage.getBytes();
				String name = book.getId() + ".png";
				
				Files.delete(Paths.get("src/main/resources/static/image/book/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/books/bookinfo?id="+book.getId();
	}
	
}
