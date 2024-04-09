package Lab9;

public class Address {
    String number;
    String street;
    String city;
    String province;
    long postcode;

    Address(String number, String street, String city, String province, long postcode){
        this.number = number;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postcode = postcode;
    }
//Ananthichai Saehui 6530613030 DE.
    public String getAddress(){
        return number + " " + street + "\n" + city + ", " + province + " " + postcode;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
