package com.example.testboot;

import com.example.testboot.Entity.Content;
import com.example.testboot.Entity.Page;
import com.example.testboot.Entity.Side;
import com.example.testboot.repository.PageRepository;
import com.example.testboot.repository.SideRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class TestbootApplicationTests {

	@Autowired
	PageRepository pageRepository;

	@Autowired
	SideRepository sideRepository;

	@Test
	public void contextLoads() {

		Content content = new Content();
//		content.setContent_id(1);
		content.setName("test_name");
		content.setText("test_text");

		Page page = new Page();
		page.setUrl("www.heise.de");
		page.setContent(content);

		pageRepository.insertPage(page);
		Page test = pageRepository.getPageById(2);
		System.out.println(pageRepository.getPageById(3));

		Side side = new Side();
		side.setName("neue Seite");
		side.setContent(content);
		sideRepository.insert(side);

		assertTrue(true);
	}

}
