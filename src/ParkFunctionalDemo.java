import model.Park;
import service.ParkService;

import java.util.Collections;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkFunctionalDemo {
    public static void main(String[] args) {
        List<Park> list = ParkService.makeListFromCSV("src\\Parks.csv");

        Collections.sort(list, (x, y) ->
                x.getParkkey().length() - y.getParkkey().length()); //정렬

//        list.removeIf(x -> !x.getCity().startsWith("B"));

        System.out.println(list.size()); //list 갯수 출력
//        list.forEach(x -> System.out.println(x)); //list 출력
        list.forEach(System.out::println); //list 출력

        //스트림
        long city = list.stream()
                .sorted((x,y) -> x.getParkkey().length() - y.getParkkey().length())
                        .filter(x -> x.getCity().startsWith("B"))
                        .count();

        System.out.println(city);



    }
}
