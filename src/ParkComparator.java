import model.Park;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class ParkComparator {
    public static void main(String[] args) {

        try {
            BufferedReader br =
                    new BufferedReader(new FileReader("src\\Parks.csv"));

            br.readLine(); //skip first line

            String line = "";
            List<Park> parkList = new ArrayList<>();

            while ((line = br.readLine()) != null) {

                String[] splitted = line.split(",");

                parkList.add(new Park(splitted[0], splitted[1],
                        splitted[2], splitted[3], splitted[4], splitted[5]));


                Collections.sort(parkList,
                        (o1, o2) -> {
                    String state1 = o1.getState();
                    String state2 = o2.getState();
                    return state1.compareTo(state2);
                });

                System.out.println(parkList.size());
                    }

                    for(Park e : parkList){
                        System.out.println(e);
                    }

        } catch (FileNotFoundException fne) {
            System.out.println("파일 이름이 잘못되었거나 없어요.");

        } catch (IOException ie) {
            System.out.println("파일을 실제로 IO하다가 에러가 발생했어요.");
        }




    }
}
