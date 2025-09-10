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

        final double averageScore = CalculateAverageScore(students);
        final Student lowestGradeStudent = SortLowestGradeStudent(students);
        final Student highestGradeStudent = SortHighestGradeStudent(students);
        final ArrayList<Student> studentsWithAverageScore = GetStudentsWithAboveAverageScore(students, averageScore);

        System.out.println();

        for (final Student student : students)
        {
            System.out.printf("%s has %d points, grade %s\n", student.GetName(), student.GetResult(), student.GetGrade());
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
}