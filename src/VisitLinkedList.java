
public class VisitLinkedList {

    private class VisitNode {

        Visit visit;
        VisitNode next;

        VisitNode(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private VisitNode head;
    private int size;

    public VisitLinkedList() {
        head = null;
        size = 0;
    }

    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        } else {

            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;

        System.out.println(
                "Visit " + visit.getVisitId()
                + " added successfully."
        );
    }

    public boolean removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return false;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            size--;

            System.out.println(
                    "Visit " + visitId + " removed successfully."
            );

            return true;
        }

        VisitNode current = head;

        while (current.next != null
                && current.next.visit.getVisitId() != visitId) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Visit ID not found.");
            return false;
        }

        current.next = current.next.next;
        size--;

        System.out.println(
                "Visit " + visitId + " removed successfully."
        );

        return true;
    }

    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    public void displayVisitHistory() {

        if (head == null) {
            System.out.println("\nVisit history is empty.");
            return;
        }

        VisitNode current = head;

        System.out.println("\n========== PATIENT VISIT HISTORY ==========");
        System.out.printf(
                "%-8s %-15s %-20s %-20s %-20s%n",
                "Visit ID",
                "Date",
                "Doctor",
                "Diagnosis",
                "Treatment"
        );

        System.out.println(
                "-------------------------------------------------------------------------------"
        );

        while (current != null) {

            Visit visit = current.visit;

            System.out.printf(
                    "%-8d %-15s %-20s %-20s %-20s%n",
                    visit.getVisitId(),
                    visit.getVisitDate(),
                    visit.getDoctorName(),
                    visit.getDiagnosis(),
                    visit.getTreatment()
            );

            current = current.next;
        }

        System.out.println(
                "-------------------------------------------------------------------------------"
        );

        System.out.println("Total visits: " + size);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}
