package edu.buu.meeting.util;

import java.util.List;

/*
 * ��ҳ������
 * */
public class ResultPage<T>{
	private List<T> list;//�б������
	private int currentPage;//��ǰҳ��
	private int totalNum;//������
	private int totalPage;//��ҳ��
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
