import model.Park;
import service.ParkService;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkFunctionalDemo2 {
    public static void main(String[] args) {
        List<Park> list = ParkService.makeListFromCSV("src\\Parks.cs");

//        list.stream()
//                .map(x -> x.getParkName().length())
//                .forEach(System.out::println);

        OptionalDouble average = list.stream()
                .mapToInt(x -> x.getParkName().length())
                .average();
//        System.out.println(result);

        if (average.isPresent()) {
            System.out.println(average.getAsDouble());
        } else {
            System.out.println("값이 없어요.");
        }
    }
}
