package day16;

import java.util.ArrayList;

public class StreamEx03 {

	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 90));
		list.add(new Student("강감찬", 87));
		list.add(new Student("홍길순", 76));
		list.add(new Student("강길동", 46));
		list.add(new Student("강길순", 67));
		
		//class에 toString 존재하면...
		//std.stream().forEach(System.out::println);
		//{} : 처리구문이 많은 경우
		list.stream().forEach(s->{ //s => new Student("홍길동",90)
			String name = s.getName(); //홍길동
			int score = s.getScore(); //90
			System.out.println(name+":"+score);
		});
		
		//합계 => intStream
		//getScore() => Integer => int변환
		// 추출 => map, 추출 후 int변환 => mapToInt
		int sum = list.stream().mapToInt(n->n.getScore()).sum();
		
		//개수
		long count = list.stream().count();
		
		System.out.println("합계 : "+sum+" 총인원 : "+count);
		
//		list.stream().forEach(System.out::println);
//		int sum = list.stream().mapToInt(n->n.getScore()).sum();
//		int cnt = (int)list.stream().mapToInt(n->n.getScore()).count();
//		System.out.println("합계 : "+sum+" 총인원 : "+cnt);
		
		//점수가 70점이상인 친구들의 합계
		int upSum = list.stream().mapToInt(n->n.getScore()).filter(f->f >= 70).sum();
		System.out.println(upSum);
		

	}
	

}
