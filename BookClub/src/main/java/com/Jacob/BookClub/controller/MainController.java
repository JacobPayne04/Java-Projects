//pair programmed with megan
package com.Jacob.BookClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Jacob.BookClub.models.Book;
import com.Jacob.BookClub.services.BookService;
import com.Jacob.BookClub.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private UserService userServ;
	private final BookService bookServ;

	public MainController(BookService bookServ) {
		this.bookServ = bookServ;
	}

	// Route to create a new book
	@GetMapping("/books/new")
	public String createBook(@ModelAttribute("book") Book book, Model model, HttpSession session,
			@RequestParam(value = "searchValue", required = false) String searchValue) {
		//checks if a user is logged in, if not redirect back to the login page
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		//if no errors renders jsp
		return "books/create.jsp";
	}

	// Route to process a new book
	@PostMapping("/books/process/new")
	public String createBookProcess(@Valid @ModelAttribute("book") Book newBook, BindingResult result) {
		//checks if a user is logged in, if not redirect back to the create form
		if (result.hasErrors()) {
			return "books/create.jsp";
		}
		//if there are no errors, create the new book
		bookServ.create(newBook);
		return "redirect:/books";
	}

//	 Route to show one book by its ID
    @GetMapping("/books/show/{id}")
    public String showOneBook(@PathVariable("id") Long id, Model model, HttpSession session) {
    		if(session.getAttribute("user_id") == null) {
    			return "redirect:/";
    		}
        model.addAttribute("oneBook", bookServ.getOne(id));
        return "books/showOne.jsp";
    }
    
	// Route to edit one book by its ID
//    @GetMapping("/books/edit/{id}")
//    public String editBook(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("book", bookServ.getOne(id));
//        return "edit.jsp";
//    }
//    
	// Route to process an edit for a book by its ID
//    @PatchMapping("/books/process/edit/{id}")
//    public String processEditBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//        if(result.hasErrors()) {
//            return "edit.jsp";
//        }
//        bookServ.edit(book);
//            return "redirect:/books";
//    }
//    
	// Route to delete a book by its ID
//    @DeleteMapping("/books/delete/{id}")
//    public String deleteBook(@PathVariable("id") Long id) {
//        bookServ.Delete(id);
//        return "redirect:/books";
//    }

}
