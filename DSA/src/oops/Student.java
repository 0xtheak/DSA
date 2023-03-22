package oops;

public class Student {
	String student;
	final int rollno;
	static int numStudents;
	
	
	public Student(String n, int rolln) {
		this.student = n;
		this.rollno = rolln;
		numStudents++;
		
	}
	
	public void setStudentName(String n) {
		this.student = n;
	}
	public void print() {
		System.out.println(this.student + " " + this.rollno);
	}
	
	public static int numStudents() {
		return numStudents;
	}
}
