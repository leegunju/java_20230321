package product;

import java.util.Scanner;

public interface ProductInterface {
	void add(Scanner scan); //메뉴 추가

	void printProduct(); //메뉴 출력

	void orderPick(String name, int count); //주문

	void printOrder(); //주문내역출력
	
	void delete(Scanner scan); //메뉴 삭제
	
	void update(Scanner scan); //메뉴 수정 - 가격 수정
}