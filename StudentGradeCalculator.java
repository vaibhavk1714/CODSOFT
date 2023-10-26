import java.util.*;

public class StudentGradeCalculator {

    public static float calculateAverage(int[] marks, int numberOfSubjects) {
        // Calculate the total marks for all subjects
        int totalMarks = 0;
        for (int i = 0; i < numberOfSubjects; i++) 
            totalMarks += marks[i];

        // Calculate the average percentage
        float averagePercentage = totalMarks/numberOfSubjects;
        return averagePercentage;
    }

    public static char calculateGrade(float averagePercentage) {

        // Return the grade according to the average percentage of the student
        if (averagePercentage >= 90) 
            return 'A';
    
        else if (75 <= averagePercentage && averagePercentage < 90) 
            return 'B';
        
        else if (60 <= averagePercentage && averagePercentage < 75) 
            return 'C';
        
        else if (45 <= averagePercentage && averagePercentage < 60) 
            return 'D';
        
        else 
            return 'E';
        
    }

    public static void main(String[] args) {
        System.out.println("\n\t\t***STUDENT GRADE CALCULATOR***\n");

        Scanner sc = new Scanner(System.in); // create a scanner object to take in user input

        // Take the number of subjects as input from user
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = sc.nextInt();
        
        // create an array of length equal to number of subjects to store the marks
        int[] marks = new int[numberOfSubjects]; 
        
        // Take the marks of each subject as input from user and ensure they lie in range 0 <= marks[i] <= 100
        System.out.println("Enter the marks of each subject out of 100: ");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("The marks for subject " + (i+1) + " : ");
            int mark = sc.nextInt();
            if(0 <= mark && mark <= 100) 
                marks[i] = mark;
            else{
                System.out.println("Please enter marks in range 0 to 100!");
                System.exit(0);
            }    
            System.out.println();
        }

        float averagePercentage = calculateAverage(marks, numberOfSubjects);

        System.out.println("\nThe Average Percentage is: " + averagePercentage);
        System.out.println("The Grade obtained is: " + calculateGrade(averagePercentage));

        sc.close();
    }
}
