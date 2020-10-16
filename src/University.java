import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class University implements school, java.io.Serializable {
    String universityName, motto;

    Student[] students;

    Faculty[] faculties;
    Person[] people;

    final

    static ArrayList<Student> studentArrayList = new ArrayList<>();
    static ArrayList<Faculty> facultyArrayList = new ArrayList<>();



    final String[] majors = new String[]{"Hardware Architecture", "Information Analytics", "Quantum Computing", "Undecided"};

    final String[] courses = new String[]{"Computers", "Advance Physics", "Quantum Entanglement", "Parallel Programming",
            "Advance Algorithms", "FPGA Programming",
            "Hardware Design", "Embedded Systems", "Signal Processing", "Artificial Intelligence",
            "Bayesian Logic", "Probability"};
    final String[] bruceCourses = new String[]{courses[10], courses[9],courses[6]};
    final String[] dianaCourses = new String[]{courses[6], courses[5], courses[7]} ;
    final String[] barbaraCourses =  new String[]{courses[11], courses[8], courses[4]};
    final String[] charlesCourses = new String[] {courses[9], courses[7], courses[3]};


    public University(String universityName, String motto) {
        this.universityName = universityName;
        this.motto = motto;

        Student billy = new Student();
        billy.firstName = "billy";
        billy.lastName = "Boston";
        billy.monthBirth = 7;
        billy.dayBirth = 12;
        billy.yearBirth = 1990;
        billy.major = "Information Anayltics";

        Student carol = new Student();
        carol.firstName = "Carol";
        carol.lastName = "Danvers";
        carol.monthBirth = 4;
        carol.dayBirth = 9;
        carol.yearBirth = 1994;
        carol.major = "Quantum Computing";

        Student clark = new Student();
        clark.firstName = "Clark";
        clark.lastName = "Danvers";
        clark.monthBirth = 4;
        clark.dayBirth = 5;
        clark.yearBirth = 1994;
        clark.major = "Hardware Architecture";

        Student kara = new Student();
        kara.firstName = "Kara";
        kara.lastName = "Zore";
        kara.monthBirth = 4;
        kara.dayBirth = 13;
        kara.yearBirth = 1989;
        kara.major = "Hardware Architecture";

        Student peter = new Student();
        peter.firstName = "Peter";
        peter.lastName = "PArker";
        peter.monthBirth = 6;
        peter.dayBirth = 25;
        peter.yearBirth = 1997;
        peter.major = "Quantum Computing";

        Student tony = new Student();
        tony.firstName = "Tony";
        tony.lastName = "Stark";
        tony.monthBirth = 2;
        tony.dayBirth = 2;
        tony.yearBirth = 2004;
        tony.major = "Hardware Achitecture";

        Student stephen = new Student();
        stephen.firstName = "Stephen";
        stephen.lastName = "Strange";
        stephen.monthBirth = 12;
        stephen.dayBirth = 15;
        stephen.yearBirth = 1976;
        stephen.major = "Quantum Computing";

        Student bruce = new Student();
        bruce.firstName = "Bruce";
        bruce.lastName = "Banner";
        bruce.monthBirth = 9;
        bruce.dayBirth = 9;
        bruce.yearBirth = 2000;
        bruce.major = "Undecided";

        studentArrayList.add(billy);
        studentArrayList.add(carol);
        studentArrayList.add(clark);
        studentArrayList.add(kara);
        studentArrayList.add(peter);
        studentArrayList.add(tony);
        studentArrayList.add(stephen);
        studentArrayList.add(bruce);

        students = new Student[]{billy,carol,clark,kara,peter,tony,stephen,bruce};

        Faculty wayne = new Faculty();
        wayne.firstName = "Bruce";
        wayne.lastName = "Wayne";
        wayne.monthBirth = 9;
        wayne.dayBirth = 27;
        wayne.yearBirth = 1995;
        wayne.courses = bruceCourses;

        Faculty diana = new Faculty();
        diana.firstName = "Diana";
        diana.lastName = "Prince";
        diana.monthBirth = 11;
        diana.dayBirth = 5;
        diana.yearBirth = 2006;
        diana.courses = dianaCourses;

        Faculty barbara = new Faculty();
        barbara.firstName = "Barbara";
        barbara.lastName = "Gordon";
        barbara.monthBirth = 5;
        barbara.dayBirth = 23;
        barbara.yearBirth = 1980;
        barbara.courses = barbaraCourses;

        Faculty charles = new Faculty();
        charles.firstName = "Charles";
        charles.lastName = "Xavier";
        charles.monthBirth = 11;
        charles.dayBirth = 5;
        charles.yearBirth = 1966;
        charles.courses = charlesCourses;

        faculties = new Faculty[]{wayne, diana, barbara, charles};
        facultyArrayList.add(wayne);
        facultyArrayList.add(diana);
        facultyArrayList.add(barbara);
        facultyArrayList.add(charles);

    }

    public Student findStudent(String fn, String ln) {
        Student student = null;
        boolean found = false;
        for (int i = 0; i < students.length; i++){
            if(students[i].firstName.equals(fn)){
               if (students[i].lastName.equals(ln)){
                   System.out.println("Student Exists.");
                   System.out.println("Student: "+ students[i].firstName + " " + students[i].lastName + "\n" +
                           "DOB: "+ students[i].monthBirth +"/" + students[i].dayBirth +"/"+students[i].yearBirth +"\n"+
                           "Major: " + students[i].major);
                            found = true;
                   break;
               }
            }

        }
        if (!found){System.out.println("not found");}
        return student;

    }

    public Faculty findFaculty(String fn, String ln) {
        Faculty faculty = null;
        boolean found = false;
        for (int i = 0; i <faculties.length;i++){
            if(faculties[i].firstName.equals(fn)){
                if(faculties[i].lastName.equals(ln)){
                    System.out.println("Faculty: "+ faculties[i].firstName + " " + faculties[i].lastName + "\n" +
                            "DOB: "+ faculties[i].monthBirth +"/" + faculties[i].dayBirth +"/"+faculties[i].yearBirth +"\n"+
                            "courses " + Arrays.toString(faculties[i].courses));
                    found = true;
                    break;
                }
            }
        }
        if (!found){System.out.println("not found");}
        return faculty;
    }

    public Faculty hire(Person p) {
        Faculty faculty = null;
        Faculty[] newFacultyArr = new Faculty[faculties.length + 1];
        faculties = Arrays.copyOf(faculties, faculties.length+1);
        faculties[faculties.length-1] = (Faculty) p;
        return faculty;
    }

    public Student admit(Person p) {
        return null;
    }

    public Person[] getAllPersons() {
        people = new Person[faculties.length + students.length];
        people = Stream.concat(Arrays.stream(faculties), Arrays.stream(students)).toArray(Person[]::new);
        return people;
    }

    public String[] getAllMajors() {
        return majors;
    }

    public String[] getAllCourses() {
        return courses;
    }

    public Person[] getStudents() {
        return students;
    }

    public Person[] getFaculty() {
        return faculties;
    }
}

interface school{
    Student findStudent(String fn, String ln);
    Faculty findFaculty(String fn, String ln);
    Faculty hire(Person p);
    Student admit(Person p);
    Person [] getAllPersons();
    String [] getAllMajors();
    String [] getAllCourses();
    Person [] getStudents();
    Person [] getFaculty();
}
