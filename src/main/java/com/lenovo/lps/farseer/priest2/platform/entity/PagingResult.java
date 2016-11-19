package com.lenovo.lps.farseer.priest2.platform.entity;

import java.util.List;

public class PagingResult<T> {
	private Long totalPages;// 总页数
	private Long totalRecords;// 总记录数
	private Integer pageNo;// 当前页号
	private Integer pageSize;// 每页大小

	private List<T> results;// 查询结果

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
	
	
}
