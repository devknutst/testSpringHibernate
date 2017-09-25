package com.example.testboot.Controller;

import com.example.testboot.Entity.Page;
import com.example.testboot.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/test")
public class PageController {

	@Autowired
	private PageService pageService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sendHello() {
		return "here a test hello.";
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Page> getPagesService() {
		return pageService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Page getPage(@PathVariable("id") int id) {
		return pageService.getSinglePage(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePage(@PathVariable int id) {
		pageService.deletePage(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertPage(@RequestBody Page page) {
		pageService.insertPage(page);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updatePage(@RequestBody Page page) {
//		pageService.updatePage(page);
	}
}
