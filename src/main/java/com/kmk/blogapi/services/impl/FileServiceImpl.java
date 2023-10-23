package com.kmk.blogapi.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kmk.blogapi.services.FileService;


@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// filename
		String name = file.getOriginalFilename();

		// filename generated
		String randomID = UUID.randomUUID().toString();
		String filename = randomID.concat(name.substring(name.lastIndexOf(".")));

		String filePath = path + File.separator + filename;

		// create folder if NOT created
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}

		// file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return filename;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path + File.separator + fileName;
		InputStream inputStream = new FileInputStream(fullPath);
		return inputStream;
	}

}
