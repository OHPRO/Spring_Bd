package org.zerock.domain;

public class ProductVO {
	private String name;
	private double price;
	//알트+시피트+S
	public ProductVO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	//알트+시프트+R   or 오른쪽>소스>겟셋터
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	//toString도 그래도 찍을수 있음(단축키로)
	//알트 +시프트+S  -> toString 선택후 체크된거 인풋
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
}
