package Models;

public class User {
    private int userid;
    private String name;
    private String address;

    public User(int userid, String name, String address) {
        this.userid = userid;
        this.name = name;
        this.address = address;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
