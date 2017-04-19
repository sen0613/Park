package service;

import model.Park;

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
}
