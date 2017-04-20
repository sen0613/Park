package salary;

import com.opencsv.CSVReader;
import salary.model.Salary;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by danawacomputer on 2017-04-20.
 *
 * 1. 1900년대 평균 연봉(1985~1999) v
 * 2. 전체 레코드의 평균연봉
 * 3. 최고 연봉자와 최소 연봉자
 * 4. NL의 최고 연봉자
 * 5. NYY 구단의 평균연봉
 * 6. 최상위연봉자 10명의 평균
 *
 * * 코딩순서
 * 1. Salary모델 객체를 만든다.(멤버변수 5개)
 * *yealID는 LocalDate타입으로, salary는 int타입으로 만든다.
 * 2. Stream을 사용하여 결과를 구한다.
 *
 */
public class SalaryAssignment {
    public static void main(String[] args) {
        CSVReader reader = null;
        List<Salary> list = new ArrayList<>();

        try {
            reader = new CSVReader(
                        new FileReader("src\\Salaries.csv"));
            reader.readNext();
            String[] spl = null;
            while ((spl = reader.readNext()) != null) {
                list.add(new Salary (
                        LocalDate.of(Integer.parseInt(spl[0]),1,1), spl[1], spl[2], spl[3], Integer.parseInt(spl[4])));
            }
            //1. 1900년대 평균 연봉(1985~1999)
            OptionalDouble average = list.stream()
                    .filter(x -> x.getYearID().getYear() < 2000)
                    .mapToInt(x -> x.getSalary())
                    .average();
            if (average.isPresent()) {
                double avg = average.getAsDouble();
                System.out.println(avg);
            } else {
                System.out.println("no data");
            }

            //2. 전체 레코드의 평균연봉
            OptionalDouble average2 = list.stream()
                    .mapToInt(x -> x.getSalary())
                    .average();
            if (average.isPresent()) {
                double avg = average.getAsDouble();
                System.out.println(average2.getAsDouble());
            } else {
                System.out.println("no data");
            }

            //3. 3-1) 최고 연봉자
            Salary HighestSal = list.stream()
                    .sorted((o1, o2) -> o2.getSalary() - o1.getSalary())
                    .findFirst()
                    .get();
            System.out.println(HighestSal.getPlayerID());
            // 3-2) 최저 연봉자
            Salary LowestSal = list.stream()
                    .sorted((o1, o2) -> o1.getSalary() - o2.getSalary())
                    .findFirst()
                    .get();
            System.out.println(LowestSal.getPlayerID());

            //4. NL의 최고 연봉자
            Salary theHighestOfNL = list.stream()
                    .sorted((o1, o2) -> o2.getSalary() - o1.getSalary())
                    .filter(x -> !x.getLgID().equals("NL"))
                    .findFirst()
                    .get();
            System.out.println(theHighestOfNL.getPlayerID());

            //5. NYY 구단의 평균연봉
            OptionalDouble averageOfNYY = list.stream()
                    .filter(x -> x.getTeamID().equals("NYY"))
                    .mapToInt(x -> x.getSalary())
                    .average();
            if (average.isPresent()) {
                double avg = average.getAsDouble();
                System.out.println(averageOfNYY.getAsDouble());
            } else {
                System.out.println("no data");
            }

            //6. 최상위연봉자 10명의 평균
            OptionalDouble avgOfTopTen = list.stream()
                    .limit(10)
                    .sorted((x,y) -> y.getSalary()-(x.getSalary()))
                    .mapToInt(x -> x.getSalary())
                    .average();
            if (average.isPresent()) {
                double avg = average.getAsDouble();
                System.out.println(avgOfTopTen.getAsDouble());
            } else {
                System.out.println("no data");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
