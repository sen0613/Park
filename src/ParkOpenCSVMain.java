import com.opencsv.CSVReader;
import model.Park;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by danawacomputer on 2017-04-19.
 */
public class ParkOpenCSVMain {
    public static void main(String[] args) {

        try {
            CSVReader reader = new CSVReader(
                    new FileReader("src\\Parks.csv"));

            List<Park> list = new ArrayList<>();

            reader.readNext();
            String[] spl = null;
            while ((spl = reader.readNext()) != null) {
                list.add(new Park(spl[0], spl[1], spl[2], spl[3], spl[4], spl[5]));

            }

            Collections.sort(list, (a, b) -> a.getState().compareTo(b.getState()));


            // 특정 element 제거하기
//            Predicate<Park> p = new Predicate<Park>() {
//                @Override
//                public boolean test(Park park) {
//                    return park.getParkAlias() == null || park.getParkAlias().equals("");
//                }
//            };

            list.removeIf(p -> p.getParkAlias() == null || p.getParkAlias().equals(""));

            list.forEach(x -> System.out.println(x));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

