import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

       contacts.put(
    "Tony Stark",
    new Contact("Tony Stark", "+1 860 555 0101")
);

contacts.put(
    "Captain America",
    new Contact("Captain America", "+1 860 555 0102")
);

contacts.put(
    "Doctor Strange",
    new Contact("Doctor Strange", "+1 860 555 0103")
);

contacts.put(
    "The Thor",
    new Contact("The Thor", "+1 860 555 0104")
);

contacts.put(
    "Black Widow",
    new Contact("Black Widow", "+1 860 555 0105")
);

        Contact found = contacts.get("Tony Stark");

        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }

        Contact missing = contacts.get("Mr Hulk");

        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missing);
        }

        ArrayList<Contact> sorted =
                new ArrayList<>(contacts.values());

        sorted.sort(
            (a, b) -> a.getName().compareTo(b.getName())
        );

        System.out.println();
        System.out.println("=== All Contacts ===");

        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}