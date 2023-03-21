package day15;

import java.io.IOException;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) throws IOException {
		
		WordManager wm = new WordManager();
		wm.add();
		Scanner scan = new Scanner(System.in);
		//wm.wordSize(scan);
		int menu = -1;
		do {
			wm.printMenu();
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: wm.addWord(scan); break;
			case 2: wm.printWord(); break;
			case 3: wm.searchWord(scan); break;
			case 4: wm.updateWord(scan); break;
			case 5: wm.deleteWord(scan); break;
			case 6: wm.filePrintWord(); break;
			case 7: break;
			default:
				System.out.println("메뉴 오류~!!");
			}
						
		} while(menu != 7);
		System.out.println("프로그램 종료");


	}

}
