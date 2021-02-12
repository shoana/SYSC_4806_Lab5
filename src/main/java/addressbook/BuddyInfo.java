package addressbook;

import javax.persistence.*;


@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;

    @ManyToOne
    private AddressBook addressBook;


    public BuddyInfo(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    public BuddyInfo(String name){
        this(name, null, null);
    }

    public BuddyInfo() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress(){return address;}

    public void setAddress(String address){this.address = address;}

    @Override
    public String toString() {
        String value = "";
        value += "Name: " + this.name;

        if(this.phoneNumber != null) value += ", Phone Number: " + this.phoneNumber;

        return value;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
}
