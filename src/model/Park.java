package model;

/**
 * Created by danawacomputer on 2017-04-12.
 */
public class Park {
    private String parkkey;
    private String parkName;
    private String parkAlias;
    private String city;
    private String state;
    private String country;

    //Default 생성자 만들기
    public Park() {}


    // 생성자 만들기
    public Park(String parkkey, String parkName, String parkAlias, String city, String state, String country) {
        this.parkkey = parkkey;
        this.parkName = parkName;
        this.parkAlias = parkAlias;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getParkkey() {
        return parkkey;
    }

    public void setParkkey(String parkkey) {
        this.parkkey = parkkey;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkAlias() {
        return parkAlias;
    }

    public void setParkAlias(String parkAlias) {
        this.parkAlias = parkAlias;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkkey='" + parkkey + '\'' +
                ", parkName='" + parkName + '\'' +
                ", parkAlias='" + parkAlias + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
