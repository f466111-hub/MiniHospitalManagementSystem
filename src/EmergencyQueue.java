
public class EmergencyQueue {

    private class QueueNode {

        Patient patient;
        QueueNode next;

        QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;
    private int size;

    // Constructor
    public EmergencyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(Patient patient) {

        QueueNode newNode = new QueueNode(patient);

        // If queue is empty
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;

        System.out.println(
                "Patient " + patient.getPatientId()
                + " added to emergency queue."
        );
    }

    public Patient dequeue() {

        // Check if queue is empty
        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;

        front = front.next;

        // If queue becomes empty
        if (front == null) {
            rear = null;
        }

        size--;

        System.out.println(
                "Patient " + patient.getPatientId()
                + " removed from emergency queue."
        );

        return patient;
    }

    public Patient peek() {

        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        return front.patient;
    }

    public void displayQueue() {

        if (front == null) {
            System.out.println("\nEmergency queue is empty.");
            return;
        }

        QueueNode current = front;

        System.out.println("\n========== EMERGENCY QUEUE ==========");
        System.out.printf("%-5s %-12s %-20s %-8s %-20s%n",
                "No.", "Patient ID", "Name", "Age", "Condition");
        System.out.println("---------------------------------------------------------------");

        int number = 1;

        while (current != null) {

            Patient patient = current.patient;

            System.out.printf("%-5d %-12d %-20s %-8d %-20s%n",
                    number,
                    patient.getPatientId(),
                    patient.getPatientName(),
                    patient.getAge(),
                    patient.getMedicalCondition());

            current = current.next;
            number++;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Patients waiting: " + size);
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }
}
