package service;

import com.opencsv.CSVReader;
import model.Park;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-12.
 * 1. 43번 구장에 대한 정보를 하나의 객체로 나타내기 -> String 배열로 만들기
 */
public class ParkService {
    public static void main(String[] args) {
        Park cubs = new Park();

        cubs.setParkkey("CHI11");
        cubs.setParkName("Wringley Field");
        cubs.setParkAlias("Weeghman Park; Cubs Park");
        cubs.setState("IL");
        cubs.setCity("Chicago");
        cubs.setCountry("USA");


//        // 이렇게 하는 건 너무 수고롭기 때문에 클래스 Park에 생성자를 만든다. ↓

        Park ohio = new Park("CIN02", "Avenue Ground",
                "", "Cincinnati", "OH", "USA");

        List<Park> list = new ArrayList<>();

        list.add(cubs);
        list.add(ohio);

    }

    public static List<Park> makeListFromCSV(String filename) {
        List<Park> list2 = new ArrayList<>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filename));
            reader.readNext(); // skip the first line
            String[] spl = null;
            while ((spl = reader.readNext()) != null) {
                list2.add(new Park(spl[0], spl[1], spl[2], spl[3], spl[4], spl[5]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없어요.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list2;
    }

    public static String resolveCountry(String code) {
        switch (code) {
            case "US":
                return "미국";
            case "CA":
                return "캐나다";
            case "AU":
                return "호주";
            case "JP":
                return "일본";
            case "PR":
                return "푸에르토리코";
            case "MX":
                return "멕시코";
            default:
                return "무명국";
        }
    }
}
