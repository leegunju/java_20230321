package day15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class WordManager {
	private ArrayList<Word> wordList = new ArrayList<>();
	
//	public void wordSize(Scanner scan) {
//		System.out.println("입력할 단어 개수:");
//		int size = scan.nextInt();
//		while(wordList.size() < size) {
//			System.out.println("단어:");
//			String word = scan.next();
//			System.out.println("의미:");
//			scan.nextLine();
//			String mean = scan.nextLine();
//			wordList.add(new Word(word, mean));
//		}
//				
//		for(Word tmp : wordList) {
//			System.out.println(tmp);
//		}	
//	}
	
	public void printMenu() {
		System.out.println(">>단어장");
		System.out.println("1.단어추가");
		System.out.println("2.단어출력");
		System.out.println("3.단어검색");
		System.out.println("4.단어수정");
		System.out.println("5.단어삭제");
		System.out.println("6.파일로 출력");
		System.out.println("7.종료");
		System.out.println("--------");
	}

	public void addWord(Scanner scan) {
		System.out.println("추가할 단어를 입력하세요.");
		String word = scan.next();
		System.out.println("단어의 의미를 입력하세요.");
		String mean = scan.next();
		wordList.add(new Word(word, mean));
		System.out.println("단어가 추가되었습니다.");		
	}

	public void printWord() {
		System.out.println("----menu----");
		Collections.sort(wordList, new Comparator<Word>() {

			@Override
			public int compare(Word o1, Word o2) {
				
				return o1.getWord().compareTo(o2.getWord());
			}
			
		});
		for(Word w: wordList) {
			System.out.println(w);
		}
		System.out.println("------------");	
	}

	public void searchWord(Scanner scan) {
		System.out.println("검색할 단어를 입력하세요.");
		String word = scan.next();
		int index = -1;
		for(int i=0; i<wordList.size(); i++) {
			if(wordList.get(i).getWord().equals(word)) {
				index = i;
				System.out.println(wordList.get(i));
			}
		}
		if(index == -1) {
			System.out.println("검색된 단어가 없습니다.");
		}
		
	}

	public void updateWord(Scanner scan) {
		int index = -1;
		System.out.println("1번은 단어 수정/2번은 의미 수정");
		int menu = scan.nextInt();
		System.out.println("수정할 단어를 입력하세요.");
		String word = scan.next();
		if(menu == 1) {			
			for(int i=0; i<wordList.size(); i++) {
				if(wordList.get(i).getWord().equals(word)) {
					index = i;
					System.out.println("수정하고 싶은 단어를 입력하세요.");
					String updateword = scan.next();
					wordList.get(i).setWord(updateword);
					System.out.println("단어 수정 완료!!");
					return;
				}
			}		
		} else {	
			for(int i=0; i<wordList.size(); i++) {
				if(wordList.get(i).getWord().equals(word)) {
					index = i;
					System.out.println("수정하고 싶은 단어의미를 입력하세요.");
					String updatemean = scan.next();
					wordList.get(i).setMean(updatemean);
					System.out.println("단어의미 수정 완료!!");
					return;
				}
			}		
		}
		
		if(index == -1) {
			System.out.println("수정할 단어가 없습니다.");
		}
		
	}

	public void deleteWord(Scanner scan) {
		System.out.println("삭제할 단어를 입력하세요");
		String word = scan.next();
		int index = -1;
		for(int i=0; i<wordList.size(); i++) {
			if(wordList.get(i).getWord().equals(word)) {
				index = i;
				wordList.remove(i);
			}
		}
		if(index == -1) {
			System.out.println("삭제할 단어가 없습니다.");
		}
	}

	public void add() {
		wordList.add(new Word("apple", "사과"));
		wordList.add(new Word("banana", "바나나"));
		wordList.add(new Word("melon", "멜론"));
		wordList.add(new Word("watermelon", "수박"));
		wordList.add(new Word("orange", "오렌지"));
		
	}

	public void filePrintWord() throws IOException {
		PrintWriter pw = new PrintWriter("word.txt");
		for(int i=0; i<wordList.size(); i++) {
			pw.println(wordList.get(i));
		}
		pw.close();
		
	}

}
