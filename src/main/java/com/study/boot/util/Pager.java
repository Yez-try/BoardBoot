package com.study.boot.util;

import lombok.Data;

@Data
public class Pager {

	private String kind;
	private String search;
	private Integer page;
	private Integer perPage;
	private Integer startRow;
	private Integer lastPage;
	
	public void calRow(Integer total) {
		this.lastPage = (total/this.getPerPage())+1;
		this.startRow = (this.getPage()-1)*this.getPerPage();
	}
	
	public Integer getPage() {
		if(this.page==null) {
			this.page = 1;
		}
		return this.page;
	}
	
	public Integer getPerPage() {
		if(this.perPage == null) {
			this.perPage=10;
		}
		return this.perPage;
	}
	
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return this.search;
	}
	
}
