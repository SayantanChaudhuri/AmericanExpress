package com.newsbulletin.components;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.newsbulletin.models.NewsBulletinVO;

@Component
public class CSVDataLoader {

	void setup() throws IOException {
		
		CsvMapper mapper = new CsvMapper();
		CsvSchema bootstrapSchema = CsvSchema.emptySchema().withoutHeader();
		File file = new ClassPathResource("news_bulletin.csv").getFile();
		
		MappingIterator<NewsBulletinVO> readValues = 
		          mapper.readerFor(NewsBulletinVO.class).with(bootstrapSchema).readValues(file);
		
		readValues.readAll();
	}
}
