package org.zerock.domain;

public class ProductVO {
	private String name;
	private double price;
	//��Ʈ+����Ʈ+S
	public ProductVO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	//��Ʈ+����Ʈ+R   or ������>�ҽ�>�ټ���
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	//toString�� �׷��� ������ ����(����Ű��)
	//��Ʈ +����Ʈ+S  -> toString ������ üũ�Ȱ� ��ǲ
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
}
