import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class UniversityDriver {
    static Scanner userInput = new Scanner(System.in);
    static boolean run = true;
    public static void main(String[] args) {

    //will check if file exists
        File f = new File("/tmp/UniversityPersons.per");

        if (f.exists()){
            System.out.println("EXISTS");
            University university = null;
            //deserialize code from here
            try {
                FileInputStream fileInputStream = new FileInputStream("/tmp/UniversityPersons.per");
                ObjectInputStream in = new ObjectInputStream(fileInputStream);
                university = (University) in.readObject();
                in.close();
                fileInputStream.close();
            }
            catch (IOException i){
                i.printStackTrace();
                return;
            }
            catch (ClassNotFoundException c){
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
            //to here

            label:
            while (run){
                String userTyped = userInput.nextLine();
                switch (userTyped) {
                    case "list majors":
                        String majors = Arrays.toString(university.getAllMajors())
                                .replace("[", "")
                                .replace("]", "");
                        System.out.println(majors);
                        break;
                    case "list courses":
                        String courses = Arrays.toString(university.getAllCourses())
                                .replace("[", "")
                                .replace("]", "");
                        System.out.println(courses);
                        break;
                    case "list students":
                        Person[] studentArr = university.getStudents();
                        for (int i= 0; i < studentArr.length;i++ ){
                            System.out.println(studentArr[i].firstName + " " + studentArr[i].lastName);
                        }
                        break;
                    case "list faculty":
                       Person[] facultyArr = university.getFaculty();
                       for (int i = 0; i < facultyArr.length;i++){
                           System.out.println(facultyArr[i].firstName + " " + facultyArr[i].lastName);
                       }
                        break;
                    case "find student":
                        Scanner scanFn = new Scanner(System.in);
                        String firstName;
                        System.out.println("Enter a students first name and press enter.");
                        firstName = scanFn.nextLine();
                        Scanner scanLn = new Scanner(System.in);
                        String lastName;
                        System.out.println("Enter the students last name and press enter");
                        lastName = scanLn.nextLine();
                        university.findStudent(firstName, lastName);
                        break;
                    case "find faculty":
                        Scanner scanFn2 = new Scanner(System.in);
                        String facultyName;
                        System.out.println("Enter a faculties first name and press enter.");
                        facultyName = scanFn2.nextLine();
                        Scanner scanLn2 = new Scanner(System.in);
                        String facultyLastName;
                        System.out.println("Enter the faculties last name and press enter");
                        facultyLastName = scanLn2.nextLine();
                        university.findFaculty(facultyName, facultyLastName);
                        break;
                    case "hire":
                        int j = 0;
                        while (j < 6) {
                            Scanner scanner = new Scanner(System.in);
                            Faculty p = new Faculty();
                            System.out.println("Enter last name");
                            p.lastName = scanner.nextLine();
                            j++;
                            System.out.println("Enter first name");
                            j++;
                            p.firstName = scanner.nextLine();
                            j++;
                            System.out.println("Year");
                            p.yearBirth = scanner.nextInt();
                            j++;
                            System.out.println("Month");
                            j++;
                            p.monthBirth = scanner.nextInt();
                            j++;
                            System.out.println("Day");
                            p.dayBirth = scanner.nextInt();
                            university.hire(p);

                        }
                    case "list everyone":
                        String people = Arrays.toString(university.getAllPersons())
                                .replace("[",""
                                .replace("]",""));
                        System.out.println(people);
                        break;
                    case "Exit":
                        break label;
                }
            }
        }
        else if (!f.exists()){
            System.out.println("file not found");
            University university = new University("HERO","Home of the HEROES");
            label:
            while (run){
                String userTyped = userInput.nextLine();
                switch (userTyped) {
                    case "list majors":
                        String majors = Arrays.toString(university.getAllMajors())
                                .replace("[", "")
                                .replace("]", "");
                        System.out.println(majors);
                        break;
                    case "list courses":
                        String courses = Arrays.toString(university.getAllCourses())
                                .replace("[", "")
                                .replace("]", "");
                        System.out.println(courses);
                        break;
                    case "list students":
                        Person[] studentArr = university.getStudents();
                        for (int i= 0; i < studentArr.length;i++ ){
                            System.out.println(studentArr[i].firstName + " " + studentArr[i].lastName);
                        }
                        break;
                    case "list faculty":
                        String faculty = Arrays.toString(university.getFaculty())
                                .replace("[", "")
                                .replace("]", "");
                        System.out.println(faculty);
                        break;
                    case "find student":
                        Scanner scanFn = new Scanner(System.in);
                        String firstName;
                        System.out.println("Enter a students first name and press enter.");
                        firstName = scanFn.nextLine();
                        Scanner scanLn = new Scanner(System.in);
                        String lastName;
                        System.out.println("Enter the students last name and press enter");
                        lastName = scanLn.nextLine();
                        university.findStudent(firstName, lastName);
                        break;
                    case "find faculty":
                        Scanner scanFn2 = new Scanner(System.in);
                        String facultyName;
                        System.out.println("Enter a faculties first name and press enter.");
                        facultyName = scanFn2.nextLine();
                        Scanner scanLn2 = new Scanner(System.in);
                        String facultyLastName;
                        System.out.println("Enter the faculties last name and press enter");
                        facultyLastName = scanLn2.nextLine();
                        university.findFaculty(facultyName, facultyLastName);
                        break;
                    case "hire":
                        int j = 0;
                        while (j < 5) {
                            Scanner scanner = new Scanner(System.in);
                            Person p = new Person();
                            System.out.println("Enter last name");
                            p.lastName = scanner.nextLine();
                            j++;
                            System.out.println("Enter first name");
                            j++;
                            p.firstName = scanner.nextLine();
                            j++;
                            System.out.println("Year");
                            p.yearBirth = scanner.nextInt();
                            j++;
                            System.out.println("Month");
                            j++;
                            p.monthBirth = scanner.nextInt();
                            j++;
                            System.out.println("Day");
                            p.dayBirth = scanner.nextInt();
                            university.hire(p);
                        }
                    case "list everyone":
                        Person[] arr = university.getAllPersons();
                        for (int i = 0; i < arr.length;i ++){
                            System.out.println(arr[i].firstName + " " + arr[i].lastName);
                        }
                        break;


                    case "Exit":
                        break label;
                }
            }
            // every method adds and hire should do this!
            try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/UniversityPersons.per");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(university);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved");
          }
            catch (IOException i)
            { i.printStackTrace();}
        }

    }





    }






