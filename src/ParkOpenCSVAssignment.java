import com.opencsv.CSVReader;
import model.Park;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class ParkOpenCSVAssignment {
    public static void main(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader("src\\Parks.csv"));
            String[] spl;
            reader.readNext();
            List<Park> list = new ArrayList<>();

            while ((spl = reader.readNext()) != null) {
                list.add(new Park(spl[0], spl[1], spl[2], spl[3], spl[4], spl[5]));

            }
            //1. sort: park.name의 글자수
            Collections.sort(list,
                    ((o1, o2) -> o1.getParkName().length() - o2.getParkName().length()));

            //2. filtering : 국가가 US가 아닌 것
            list.removeIf(p -> p.getCountry().equals("US"));

            //3. 출력 : forEach(..)
            list.forEach(x -> System.out.println(x));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}