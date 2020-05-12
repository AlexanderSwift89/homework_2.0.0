import java.util.TreeMap;
import java.util.Map;
import java.time.*;

public class MissedCalled {
    Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCalled(String missedCall) {
        LocalDateTime localDateTime;
        localDateTime = LocalDateTime.now();
        missedCalls.put(localDateTime, missedCall);
    }

    public void getAllMissedCalled(Contacts contacts) {
        for (LocalDateTime keyMissedCalls : missedCalls.keySet()) {
            if (contacts.checkContacts(missedCalls.get(keyMissedCalls))) {
                Contact contact = contacts.getValueContacts(missedCalls.get(keyMissedCalls));
                System.out.println(contact.getName() + " " + contact.getSurname());
            } else {
                System.out.println("Телефон: " + missedCalls.get(keyMissedCalls));
            }
        }
    }

    public void clearAllMissedCalled() {
        missedCalls.clear();
    }
}