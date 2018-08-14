package com.newsbulletin.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class NewsBulletinVO {
	
	@NonNull
	private Long id;
	
	@NonNull
	private String newsText;
	
	@NonNull
	private String newsLink;
	
	@NonNull
	private String publisherName;
	
	@NonNull
	private String publisherLink;
	
	@NonNull
	private String newsType;
	
	@NonNull
	private Long newPublishTime;
}
