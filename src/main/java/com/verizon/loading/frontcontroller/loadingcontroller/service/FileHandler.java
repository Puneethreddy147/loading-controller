package com.verizon.loading.frontcontroller.loadingcontroller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.verizon.loading.frontcontroller.loadingcontroller.model.Bookstore;

@Service
public interface FileHandler {
	
	
	
	public List<Bookstore> loadFiles() throws Exception;

}
