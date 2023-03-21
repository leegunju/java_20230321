package day16;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		/* 문자열(이름)을 담는 리스트 생성후, 스트림으로 생성
		 * 정렬하여 출력
		 */
		
		ArrayList<String> list = new ArrayList<>();
		list.add("사과");
		list.add("오렌지");
		list.add("멜론");
		list.add("수박수박수박");
		
		Stream<String> st = list.stream();
		st.sorted().forEach(s->System.out.println(s));
		System.out.println("-----------");
		//글자수가 5글자 이상인 이름만 출력
		list.stream().sorted().forEach(s->System.out.println(s));
		System.out.println("-----------");
		list.stream().filter(b->b.length() >= 5).forEach(s->System.out.println(s));
		
		//각자 이름의 글자수를 출력
		System.out.println("-----------");
		list.stream().map(n->n.length()).forEach(System.out::println);

	}

}
