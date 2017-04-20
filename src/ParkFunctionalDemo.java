import model.Park;
import service.ParkService;

import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class ParkFunctionalDemo {
    public static void main(String[] args) {
        List<Park> list = ParkService.makeListFromCSV("src\\Parks.csv");
//
//        Collections.sort(list, (x, y) ->
//                x.getParkkey().length() - y.getParkkey().length()); //정렬
//
////        list.removeIf(x -> !x.getCity().startsWith("B"));
//
//        System.out.println(list.size()); //list 갯수 출력
////        list.forEach(x -> System.out.println(x)); //list 출력
//        list.forEach(System.out::println); //list 출력

        //스트림
//        long count = list.stream()
//                .sorted((x,y) -> x.getParkkey().compareTo(y.getParkkey()))
//                        .filter(x -> !x.getCity().startsWith("B"))
//                        .count();
//
//        System.out.println(count);
//
//        list.stream()
//                .map(x -> {
//                    String alias = x.getParkAlias();
//                    if(alias == null || alias.equals("")) {
//                        alias = "없음";
//                    }
//                    x.setParkAlias(alias);
//                    return x;
//                })
//                .forEach(x -> System.out.println(x));

//        list.stream()
//                .map(x -> {
//                    x.setCity(x.getCity().toLowerCase());
//                    return x;
//                })
//                .forEach(x -> {
//                    System.out.println(x);
//                });

        //첫 10줄은 skip하고 전체 중 10개만 나타낼 때, city는 앞 세 글자만 나타내고 state는 소문자로 바꾸기
        List<Park> resultList =
        list.stream()
                .skip(10)
                .limit(10)

                .map(x -> {
                    x.setCity(x.getCity().substring(0, 3));
                    x.setState(x.getState().toLowerCase());
                    return x;
                })
                .peek(System.out::println)
                .map(x -> {
                    x.setCountry(ParkService.resolveCountry(x.getCountry()));
                    return x;
                })
//                .filter(x -> x.getCountry().equals("무명국"))
//                .forEach(System.out::println)
                .collect(Collectors.toList());
        resultList.forEach(System.out::println);


    }
}
