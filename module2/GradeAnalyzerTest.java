import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GradeAnalyzerTest {

    @Test
public void calculateAverage_emptyList_returnsZero() {

    ArrayList<Integer> scores = new ArrayList<>();

    double result = GradeAnalyzer.calculateAverage(scores);

    assertEquals(0.0, result, 0.001);
}
@Test
public void calculateAverage_singleScore_returnsSameScore() {

    ArrayList<Integer> scores =
            new ArrayList<>(Arrays.asList(85));

    double result = GradeAnalyzer.calculateAverage(scores);

    assertEquals(85.0, result, 0.001);
}
@Test
public void calculateAverage_multipleScores_returnsCorrectAverage() {

    ArrayList<Integer> scores =
            new ArrayList<>(Arrays.asList(80, 90, 100));

    double result = GradeAnalyzer.calculateAverage(scores);

    assertEquals(90.0, result, 0.001);
}
@Test
public void calculateAverage_scoresWithDecimalAverage_returnsCorrectValue() {

    ArrayList<Integer> scores =
            new ArrayList<>(Arrays.asList(70, 80, 95));

    double result = GradeAnalyzer.calculateAverage(scores);

    assertEquals(81.6667, result, 0.001);
}
@Test
public void calculateAverage_sameScores_returnsSameValue() {

    ArrayList<Integer> scores =
            new ArrayList<>(Arrays.asList(75, 75, 75, 75));

    double result = GradeAnalyzer.calculateAverage(scores);

    assertEquals(75.0, result, 0.001);
}
}