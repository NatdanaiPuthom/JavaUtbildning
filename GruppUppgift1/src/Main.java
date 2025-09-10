import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rng = new Random();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Student> studentsWithAverageScore = new ArrayList<>();

        final String[] studentNames = StudentNamesList.GetNames();

        for (String studentName : studentNames)
        {
            students.add(new Student(studentName));
        }

        System.out.println();

        for (Student student : students)
        {
            System.out.printf("%s has %d points, grade %s\n", student.GetName(), student.GetResult(), student.GetGrade());
        }

        double averageScore = 0.0;

        Student lowestGradeStudent = students.getFirst();
        Student highestGradeStudent = students.getFirst();

        for (Student student : students)
        {
            averageScore += student.GetResult();
        }

        averageScore = averageScore / students.size();

        for (Student student : students)
        {
            if (highestGradeStudent.GetResult() < student.GetResult())
            {
                highestGradeStudent = student;
            }
        }

        for (Student student : students)
        {
            if (lowestGradeStudent.GetResult() > student.GetResult())
            {
                lowestGradeStudent = student;
            }
        }

        for (Student student : students)
        {
            if (student.GetResult() >= averageScore)
            {
                studentsWithAverageScore.add(student);
            }
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
}