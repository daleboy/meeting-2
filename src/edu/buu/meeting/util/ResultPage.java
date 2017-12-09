package edu.buu.meeting.util;

import java.util.List;

/*
 * 分页工具类
 * */
public class ResultPage<T>{
	private List<T> list;//列表的数据
	private int currentPage;//当前页数
	private int totalNum;//总条数
	private int totalPage;//总页数
	@Override
	public String toString() {
		return "ReusltPage [currentPage=" + currentPage
				+ ", totalNum=" + totalNum + ", totalPage=" + totalPage + "]";
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
