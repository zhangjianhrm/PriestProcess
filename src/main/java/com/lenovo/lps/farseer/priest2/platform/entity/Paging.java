package com.lenovo.lps.farseer.priest2.platform.entity;

import java.util.List;

/**
 * 分页查询结果
 * 
 * @author niexm1
 * 
 */
public class Paging<T> {
	/**
	 * 默认每页30条记录
	 */
	private final Integer defaultSize = 30;
	/**
	 * 当前页号
	 */
	private Integer page;

	/**
	 * 每页记录数
	 */
	private Integer size = defaultSize;

	/**
	 * 总页数
	 */
	private Integer total;

	/**
	 * 总记录数
	 */
	private Long records;

	/**
	 * 排序字段
	 */
	private String sidx;

	/**
	 * 排序方式 asc or desc
	 */
	private String sord;

	/**
	 * 当前页记录
	 */
	private List<T> rows;

	public Paging() {
	}

	public Paging(Integer page, Integer size, Long records, String sidx,
			String sord) {
		this.page = page;
		if (size != null && size != 0) {
			this.size = size;
		}

		this.records = records;

		this.sidx = sidx;

		this.sord = sord;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Long getRecords() {
		return records;
	}

	public void setRecords(Long records) {
		this.records = records;
		this.total = Long
				.valueOf(records / size + records % size == 0 ? 0 : +1)
				.intValue();
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

}
