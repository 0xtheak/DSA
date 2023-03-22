package oops;

public class StudentUse {

	public static void main(String[] args) {
		Student s1 = new Student("Aamir khan", 1);
		Student s2 = new Student("Aasif Khan", 2);
		s2.print();
		System.out.println(Student.numStudents );
		System.out.println(s2.numStudents);
		System.out.println(Student.numStudents());

	}

}
