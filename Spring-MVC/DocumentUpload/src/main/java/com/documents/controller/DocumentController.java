package com.documents.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.w3c.dom.ranges.DocumentRange;
import org.w3c.dom.ranges.Range;

import com.documents.entity.Document;
import com.documents.repos.DocumentRepository;

@Controller
public class DocumentController {

	@Autowired
	private DocumentRepository repo;

	@RequestMapping("displayDocPage")
	public String displayDocpage(ModelMap modelmap) {
		List<Document> documents = repo.findAll();
		modelmap.addAttribute("documents", documents);
		return "documentUpload";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String displayDocpage(@RequestParam("document") MultipartFile multipart, @RequestParam("id") long id,
			ModelMap modelmap) throws IOException {
		multipart.getName();

		Document document = new Document();
		document.setId(id);
		document.setName(multipart.getOriginalFilename());
		// System.out.println(multipart.getOriginalFilename());
		document.setData(multipart.getBytes());
		repo.save(document);

		List<Document> documents = repo.findAll();
		modelmap.addAttribute("documents", documents);
		return "documentUpload";
	}

	@RequestMapping("download")
	public StreamingResponseBody download(@RequestParam("id") long id, HttpServletResponse response) {
		Document document = repo.findById(id).get();
		byte[] data = document.getData();
		response.setHeader("Content-Disposition", "attachment;filename=download.jpeg");
		return outputStream -> {
			outputStream.write(data);
		};
	}
}
