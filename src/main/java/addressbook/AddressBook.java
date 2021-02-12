package addressbook;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "addressBook")
    private List<BuddyInfo> buddies;

    public AddressBook(Long id) {
        this.id = id;
        this.buddies = new ArrayList<BuddyInfo>();
    }

    public AddressBook(){
        this(null);
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }


    public List<BuddyInfo> getBuddies(){
        return buddies;
    }



    public Boolean removeBuddy(BuddyInfo buddy) {
        return this.buddies.remove(buddy);
    }


    public BuddyInfo getBuddy(String name) {
        for (BuddyInfo buddy: buddies) {
            if (buddy.getName().equals(name)) return buddy;
        }
        return null;
    }

    @Override
    public String toString() {
        String returnValue = "";
        for (BuddyInfo buddy: buddies) {
            returnValue += buddy.toString() + "\n";
        }
        return returnValue;
    }

    public Long getId() {
        return id;
    }
}
