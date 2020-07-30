package com.verizon.loading.frontcontroller.loadingcontroller.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.verizon.loading.frontcontroller.loadingcontroller.model.Bookstore;

@Service
public class FileHandlerImpl implements FileHandler {

	Logger log = LoggerFactory.getLogger(FileHandlerImpl.class);

	@Override
	public List<Bookstore> loadFiles() throws Exception {

		List<Bookstore> bookStoreList = new ArrayList<Bookstore>();

		try {
			List<File> filesInFolder = Files.walk(Paths.get("/Users/puneethreddy/Documents/bookstore"))
					.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
			/*
			 * filesInFolder.stream().forEach(f -> { log.info(f.getAbsolutePath()); });
			 */
			filesInFolder.forEach(list -> {
				log.info("Making controller class call :" + list);
				Bookstore bookstoreData = getBookStoreData(list);
				bookStoreList.add(bookstoreData);
			});
		} catch (Exception e) {
			throw e;
		}

		return bookStoreList;

	}

	public Bookstore getBookStoreData(File file) {
		log.info("Starting Bookstore Controller!");
		final String serverUrl = "http://localhost:8080/file-load";

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		log.info(file.getAbsolutePath());
		body.add("files", new FileSystemResource(file));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

		RestTemplate restTemplate = new RestTemplate();
		Bookstore response = restTemplate.postForObject(serverUrl, requestEntity, Bookstore.class);
		log.info("Exiting BLOCKING Controller!" + response);
		return response;
	}
}
