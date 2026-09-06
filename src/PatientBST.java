
public class PatientBST {

    private class Node {

        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    public void insert(Patient patient) {
        root = insertNode(root, patient);
    }

    private Node insertNode(Node current, Patient patient) {

        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertNode(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertNode(current.right, patient);
        } else {
            System.out.println("Patient ID already exists.");
        }

        return current;
    }

    public Patient search(int patientId) {
        Node result = searchNode(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchNode(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId == current.patient.getPatientId()) {
            return current;
        }

        if (patientId < current.patient.getPatientId()) {
            return searchNode(current.left, patientId);
        }

        return searchNode(current.right, patientId);
    }

    public void delete(int patientId) {

        if (search(patientId) == null) {
            System.out.println("Patient ID not found.");
            return;
        }

        root = deleteNode(root, patientId);
        System.out.println("Patient deleted successfully.");
    }

    private Node deleteNode(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteNode(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = deleteNode(current.right, patientId);
        } else {

            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            Node smallestNode = findMinimum(current.right);

            current.patient = smallestNode.patient;

            current.right = deleteNode(
                    current.right,
                    smallestNode.patient.getPatientId()
            );
        }

        return current;
    }

    private Node findMinimum(Node current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void inOrderTraversal() {

        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\nPatient Records (Ascending Patient ID)");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-8s %-15s %-20s%n",
                "ID", "Name", "Age", "Contact", "Condition");
        System.out.println("-------------------------------------------------------------");

        inOrder(root);

        System.out.println("-------------------------------------------------------------");
    }

    private void inOrder(Node current) {

        if (current != null) {

            inOrder(current.left);

            System.out.printf("%-10d %-20s %-8d %-15s %-20s%n",
                    current.patient.getPatientId(),
                    current.patient.getPatientName(),
                    current.patient.getAge(),
                    current.patient.getContactNumber(),
                    current.patient.getMedicalCondition());

            inOrder(current.right);
        }
    }
}
