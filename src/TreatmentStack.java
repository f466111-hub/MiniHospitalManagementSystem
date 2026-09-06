
public class TreatmentStack {

    private class StackNode {

        TreatmentRecord record;
        StackNode next;

        StackNode(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private StackNode top;
    private int size;

    public TreatmentStack() {
        top = null;
        size = 0;
    }

    public void push(TreatmentRecord record) {

        StackNode newNode = new StackNode(record);

        newNode.next = top;
        top = newNode;

        size++;

        System.out.println(
                "Treatment record "
                + record.getTreatmentId()
                + " added successfully."
        );
    }

    public TreatmentRecord pop() {

        if (top == null) {
            System.out.println("Treatment history is empty.");
            return null;
        }

        TreatmentRecord record = top.record;

        top = top.next;

        size--;

        System.out.println(
                "Treatment record "
                + record.getTreatmentId()
                + " removed from history."
        );

        return record;
    }

    public TreatmentRecord peek() {

        if (top == null) {
            System.out.println("Treatment history is empty.");
            return null;
        }

        return top.record;
    }

    public void displayStack() {

        if (top == null) {
            System.out.println("\nTreatment history is empty.");
            return;
        }

        StackNode current = top;

        System.out.println("\n========== TREATMENT HISTORY ==========");
        System.out.printf(
                "%-5s %-10s %-20s %-18s %-18s %-18s%n",
                "No.",
                "Treat ID",
                "Patient",
                "Doctor",
                "Diagnosis",
                "Treatment"
        );

        System.out.println(
                "--------------------------------------------------------------------------------"
        );

        int number = 1;

        while (current != null) {

            TreatmentRecord record = current.record;

            System.out.printf(
                    "%-5d %-10d %-20s %-18s %-18s %-18s%n",
                    number,
                    record.getTreatmentId(),
                    record.getPatientName(),
                    record.getDoctorName(),
                    record.getDiagnosis(),
                    record.getTreatment()
            );

            current = current.next;
            number++;
        }

        System.out.println(
                "--------------------------------------------------------------------------------"
        );

        System.out.println("Completed treatments: " + size);
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}
