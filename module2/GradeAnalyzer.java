import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {

        String inputFile = "scores.txt";
        String outputFile = "report.txt";

        // Step 3: Read scores from file
        ArrayList<Integer> scores = readScores(inputFile);

        // Optional check
        System.out.println("Valid scores read: " + scores);

        // Step 4: Calculate average
        double average = calculateAverage(scores);

        // Step 5: Find highest and lowest scores
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }

        // Handle empty list so MIN_VALUE/MAX_VALUE are not reported
        if (scores.isEmpty()) {
            highest = 0;
            lowest = 0;
        }

        // Step 6: Count grade bands
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {

            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        // Step 7: Write and print report
        writeReport(
                scores,
                average,
                highest,
                lowest,
                countA,
                countB,
                countC,
                countD,
                countF,
                outputFile
        );
    }


    // Step 3
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {

        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Remove leading and trailing whitespace
                line = line.trim();

                // Skip blank lines
                if (line.isEmpty()) {
                    continue;
                }

                try {

                    // Convert line to integer
                    int score = Integer.parseInt(line);

                    // Add valid score
                    scores.add(score);

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Warning: Invalid score skipped: " + line
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error reading file: " + e.getMessage()
            );
        }

        return scores;
    }


    // Step 4
    // Returns the average of a list of scores,
    // or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {

        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }


    // Step 7
    // Writes and prints the report
    public static void writeReport(
            ArrayList<Integer> scores,
            double avg,
            int high,
            int low,
            int countA,
            int countB,
            int countC,
            int countD,
            int countF,
            String outputFile) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(outputFile))) {

            String line1 = "GRADE ANALYSIS REPORT";
            String line2 = "---------------------";

            String totalLine =
                    String.format("Total scores:  %d", scores.size());

            String avgLine =
                    String.format("Average score: %.2f", avg);

            String highLine =
                    String.format("Highest score: %d", high);

            String lowLine =
                    String.format("Lowest score:  %d", low);

            String gradeHeader = "";
            String gradeTitle = "GRADE BANDS";
            String gradeDivider = "-----------";

            String aLine =
                    String.format("%-10s %d", "A (90+):", countA);

            String bLine =
                    String.format("%-10s %d", "B (80-89):", countB);

            String cLine =
                    String.format("%-10s %d", "C (70-79):", countC);

            String dLine =
                    String.format("%-10s %d", "D (60-69):", countD);

            String fLine =
                    String.format("%-10s %d", "F (<60):", countF);


            // Write report to file
            writer.write(line1);
            writer.newLine();

            writer.write(line2);
            writer.newLine();

            writer.write(totalLine);
            writer.newLine();

            writer.write(avgLine);
            writer.newLine();

            writer.write(highLine);
            writer.newLine();

            writer.write(lowLine);
            writer.newLine();

            writer.newLine();

            writer.write(gradeTitle);
            writer.newLine();

            writer.write(gradeDivider);
            writer.newLine();

            writer.write(aLine);
            writer.newLine();

            writer.write(bLine);
            writer.newLine();

            writer.write(cLine);
            writer.newLine();

            writer.write(dLine);
            writer.newLine();

            writer.write(fLine);
            writer.newLine();


            // Print same report to terminal
            System.out.println();
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(totalLine);
            System.out.println(avgLine);
            System.out.println(highLine);
            System.out.println(lowLine);
            System.out.println();

            System.out.println(gradeTitle);
            System.out.println(gradeDivider);
            System.out.println(aLine);
            System.out.println(bLine);
            System.out.println(cLine);
            System.out.println(dLine);
            System.out.println(fLine);

            System.out.println();
            System.out.println(
                    "Report written to: " + outputFile
            );

        } catch (IOException e) {

            System.out.println(
                    "Error writing report: " + e.getMessage()
            );
        }
    }
}