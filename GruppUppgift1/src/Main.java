import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        final ArrayList<Student> students = new ArrayList<>();
        final String[] studentNames = StudentNamesList.GetNames();

        for (String studentName : studentNames)
        {
            students.add(new Student(studentName));
        }

        final String studentToSearch = "Nat";
        final double averageScore = CalculateAverageScore(students);
        final Student lowestGradeStudent = SortLowestGradeStudent(students);
        final Student highestGradeStudent = SortHighestGradeStudent(students);
        final ArrayList<Student> studentsWithAverageScore = GetStudentsWithAboveAverageScore(students, averageScore);
        final ArrayList<Student> studentsFound = SearchForStudents(students, studentToSearch);

        System.out.println();

        for (final Student student : students)
        {
            System.out.printf("%-20s has %d points, grade %s\n", student.GetName(), student.GetResult(), student.GetGrade());
        }

        System.out.println();
        System.out.println(lowestGradeStudent.GetName() + " has lowest points: " + lowestGradeStudent.GetResult());
        System.out.println(highestGradeStudent.GetName() + " has highest points: " + highestGradeStudent.GetResult());
        System.out.println("Average: " + averageScore);

        System.out.println("\nStudents with above average score:");
        for (Student student : studentsWithAverageScore)
        {
            System.out.printf("%s (%d), ", student.GetName(), student.GetResult());
        }

        Student[] sortedStudents = SortStudentsBasedOnScore(students);

        System.out.println("\n\nSorted Student:");
        for (Student student : sortedStudents)
        {
            System.out.printf("%-20s: %d\n", student.GetName(), student.GetResult());
        }

        System.out.printf("%nSearched students: %s%n",studentToSearch);
        for (Student student : studentsFound)
        {
            System.out.printf("%-20s: %d\n", student.GetName(), student.GetResult());
        }
    }

    public static Student SortLowestGradeStudent(ArrayList<Student> aStudentList)
    {
        Student lowestGradeStudent = aStudentList.getFirst();

        for (Student student : aStudentList)
        {
            if (lowestGradeStudent.GetResult() > student.GetResult())
            {
                lowestGradeStudent = student;
            }
        }

        return lowestGradeStudent;
    }

    public static Student SortHighestGradeStudent(ArrayList<Student> aStudentList)
    {
        Student highestGradeStudent = aStudentList.getFirst();

        for (Student student : aStudentList)
        {
            if (highestGradeStudent.GetResult() > student.GetResult())
            {
                highestGradeStudent = student;
            }
        }

        return highestGradeStudent;
    }

    public static double CalculateAverageScore(ArrayList<Student> aStudentList)
    {
        double averageScore = 0.0;

        for (Student student : aStudentList)
        {
            averageScore += student.GetResult();
        }

        averageScore = averageScore / aStudentList.size();

        return averageScore;
    }

    public static ArrayList<Student> GetStudentsWithAboveAverageScore(ArrayList<Student> aStudentList, final double aAverageScore)
    {
        ArrayList<Student> studentsWithAverageScore = new ArrayList<>();

        for (Student student : aStudentList)
        {
            if (student.GetResult() >= aAverageScore)
            {
                studentsWithAverageScore.add(student);
            }
        }

        return studentsWithAverageScore;
    }

    public static Student[] SortStudentsBasedOnScore(ArrayList<Student> aStudentList)
    {
        final Student[] students = new Student[aStudentList.size()];

        for (int i = 0; i < aStudentList.size(); i++)
        {
            students[i] = aStudentList.get(i);
        }

        for (int i = 0; i < aStudentList.size(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (students[i].GetResult() < students[j].GetResult())
                {
                    Student tempStudent = students[i];
                    students[i] = students[j];
                    students[j] = tempStudent;
                }
            }
        }

        return students;
    }

    public static ArrayList<Student> SearchForStudents(final ArrayList<Student> aStudentList, final String aName)
    {
        final ArrayList<Student> students = new ArrayList<>();

        for (Student student : aStudentList)
        {
            if (student.GetName().contains(aName))
            {
                students.add(student);
            }
        }

        return students;
    }
}