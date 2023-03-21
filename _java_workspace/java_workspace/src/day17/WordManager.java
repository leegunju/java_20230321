package day17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import day15.Word;

public class WordManager {
	/*
	 * package day15 에서 생성한 Word 클래스 객체화해서 사용
	 */
	private ArrayList<Word> list = new ArrayList<>();
	
	//메뉴출력
	public void printMenu() {
		System.out.println("--단어장 프로그램--");
		System.out.println("1.단어등록|2.단어검색|3.단어수정");
		System.out.println("4.단어출력|5.파일로출력|6.단어삭제|7.종료");
		System.out.println("--------------------------------");
		System.out.println("menu > ");
	}
	
	//기본단어등록
	public void addWord() {
		list.add(new Word("hello", "안녕"));
		list.add(new Word("hi", "안녕"));
		list.add(new Word("apple", "사과"));
		list.add(new Word("orange", "오렌지"));
		list.add(new Word("banana", "바나나"));
	}
	
	//단어등록
	public void insertWord(Scanner scan) {
		System.out.println("단어입력:");
		String word = scan.next();
		System.out.println("의미입력:");
		String mean = scan.next();
		
		list.add(new Word(word, mean));
		
//		Word w = new Word();
//		w.setWord(scan.next());
//		w.setMean(scan.next());
//		list.add(w);
	}
	
	//단어검색
	public void searchWord(Scanner scan) {
		System.out.println("검색단어입력:");
		String word = scan.next();
		for(Word w : list) {
			if(w.getWord().equals(word)) {
				System.out.println("검색결과 > ");
				System.out.println(w);
				return;
			}
		}
		System.out.println("검색 단어가 없습니다.");
	}
	
	//단어수정
	public void modifyWord(Scanner scan) {
		System.out.println("검색단어입력:");
		String word = scan.next();
		System.out.println("수정단어입력:");
		String newWord = scan.next();
		System.out.println("수정의미입력:");
		String mean = scan.next();
		Word w = new Word(newWord, mean);
		
		//int index = -1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getWord().equals(word)) {
				//index = i;
				list.set(i, w);
				return;
			}
		}
		System.out.println("검색단어가 없습니다.");
	}
	
	//단어출력
	public void printWord() {
		System.out.println("--단어장--");
		Collections.sort(list);
		for(Word w : list) {
			System.out.println(w);
		}
		System.out.println("--------");
	}
	
	//단어 파일로 출력
	public void fileWord() throws IOException {
		FileWriter fs = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fs);
		
		//단어장의 list의 값을 String화 하기 위해 StringBuffer
		//객체 생성
		StringBuffer sb = new StringBuffer();
		String data = null;
		sb.append("단어장");
		sb.append("\r\n");
		int cnt = 0;
		Collections.sort(list);
		while(cnt < list.size()) {
			sb.append(list.get(cnt).toString());
			sb.append("\r\n");
			cnt++;
		}
		data = sb.toString();
		System.out.println(data);
		bw.write(data);
		
		bw.close();
		fs.close();
	}
	
	//단어삭제
	public void deleteWord(Scanner scan) {
		System.out.println("삭제단어입력:");
		String word = scan.next();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getWord().equals(word)) {
				list.remove(i);
				return;
			}
		}
		System.out.println("검색단어가 없습니다.");
	}

}
