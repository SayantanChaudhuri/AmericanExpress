package com.newsbulletin.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.newsbulletin.models.NewsBulletinVO;

@RestController
@CrossOrigin
public class NewsBullentinController {

	List<NewsBulletinVO> newsBulletinList = null;

	public NewsBullentinController() throws IOException {
		initData();
	}

	@GetMapping("/newsBulletin")
	public List<NewsBulletinVO> retriveAllNewsBulletin() {

		return newsBulletinList;
	}

	@GetMapping("/newsBulletin/{newsText}")
	public List<NewsBulletinVO> retriveAllNewsBulletinByNewsText(@PathVariable String newsText) {

		System.out.println("...newsText :" + newsText);

		return newsBulletinList.stream().filter(newsBulletin ->

		newsBulletin.getNewsText().toUpperCase().indexOf(newsText.trim().toUpperCase()) > -1)
				.collect(Collectors.toList());
	}

	private void initData() throws IOException {

		CsvMapper mapper = new CsvMapper();
		CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
		File file = new ClassPathResource("news_bulletin.csv").getFile();

		MappingIterator<NewsBulletinVO> readValues = mapper.readerFor(NewsBulletinVO.class).with(bootstrapSchema)
				.readValues(file);

		newsBulletinList = readValues.readAll();

	}
}
