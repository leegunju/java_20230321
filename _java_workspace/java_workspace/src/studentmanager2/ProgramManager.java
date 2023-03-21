package studentmanager2;

import java.util.ArrayList;
import java.util.Scanner;


public class ProgramManager implements Program {

	private ArrayList<Student> Student = new ArrayList<>();

	@Override
	public void StudentPrint() {
		System.out.println("-----전체 학생 정보-----");
		for (int i = 0; i < Student.size(); i++) {
			System.out.println(Student.get(i).getStuname());
		}

	}

	@Override
	public void StudentInsert(Scanner scan) {

		System.out.println("-----학생정보 입력-----");
		System.out.println("이름>");
		String stuname = scan.next();
		System.out.println("학번>");
		String stucode = scan.next();
		System.out.println("주민번호>");
		String resinum = scan.next();
		System.out.println("학부>");
		String faculty = scan.next();
		System.out.println("학과>");
		String major = scan.next();

		Student.add(new Student(stucode, stuname, resinum, faculty, major));

	}

	@Override
	public void StuentSearch(Scanner scan) {
		System.out.println("검색할 학생 이름 입력");
		String stuname = scan.next();
		for (int i = 0; i < Student.size(); i++) {
			if (stuname.equals(Student.get(i).getStuname())) {
				printStudentOne(Student.get(i));
			} else {
				System.out.println("등록된 학생이 없습니다.");
			}
		}

	}

	@Override
	public void ProgramResister(Scanner scan) {
		System.out.println("수강신청할 학생의 이름을 입력");
		String stuname = scan.next();
		int index = -1;
		for (int i = 0; i < Student.size(); i++) {
			if (stuname.equals(Student.get(i).getStuname())) {
				System.out.println("수강 신청할 과목을 입력");
				String subname = scan.next();
				Student.get(i).getSubject().add(new Subject(subname));
				index = i;
				System.out.println("수강 신청 완료");
			}
		}
		if (index == -1) {
			System.out.println("등록된 학생이 없습니다.");
		}

	}

	@Override
	public void ProgramDelete(Scanner scan) {
		System.out.println("수강 철회할 학생명을 입력");
		String name = scan.next();
		int index = -1;
		Student s = new Student();
		for (int i = 0; i < Student.size(); i++) {
			if (name.equals(Student.get(i).getStuname())) {
				index = i;
				s = Student.get(i);
				s.deleteSubject(scan);

			}
		}
		if (index == -1) {
			System.out.println("등록된 학생이 없습니다.");
		}
	}

	public void printStudentOne(Student s) {
		System.out.println("--학생정보--");
		s.stuPrint();
		System.out.println("--수강정보--");
		s.subPrint();
	}

}