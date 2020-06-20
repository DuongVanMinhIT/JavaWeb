package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewsModel;

public class NewMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet rs) {		
		try {
			NewsModel news = new NewsModel();
			
			news.setId(rs.getLong("id"));
			news.setCategory_id(rs.getLong("category_id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setShortdecription(rs.getString("shortdecription"));
			news.setCreateddate(rs.getTimestamp("createddate"));
			news.setCreatedby(rs.getString("createdby"));
			if(rs.getTimestamp("modifieddate")   != null) {
				news.setModifieddate(rs.getTimestamp("modifieddate") );
			}
			if (rs.getString("modifiedby") != null) {
				news.setModifiedby(rs.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		
	}

}
