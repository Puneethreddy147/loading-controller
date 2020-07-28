package com.verizon.loading.frontcontroller.loadingcontroller.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.loading.frontcontroller.loadingcontroller.model.Bookstore;
import com.verizon.loading.frontcontroller.loadingcontroller.service.FileHandler;

@RestController
public class FileLoadingController {

	@Autowired
	private FileHandler fileHandlerImpl;

	@GetMapping("/file-load")
	public List<Bookstore> getBookData() throws Exception {

		System.out.println("Inside Book Data Controller");

		List<Bookstore> bookStore = fileHandlerImpl.loadFiles();

		return bookStore;
	}

}
