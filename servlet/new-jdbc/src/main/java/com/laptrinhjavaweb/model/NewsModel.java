package com.laptrinhjavaweb.model;

public class NewsModel extends AbstracModel<NewsModel>{
	private long category_id ;
	private String title ;
	private String thumbnail; 
	private String shortdecription ;
	private String content ;
	private String categoryCode;
	
	
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortdecription() {
		return shortdecription;
	}
	public void setShortdecription(String shortdecription) {
		this.shortdecription = shortdecription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
}
