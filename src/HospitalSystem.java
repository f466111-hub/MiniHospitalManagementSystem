
import java.util.HashMap;
import java.util.Map;

public class HospitalSystem {

    private PatientBST patientBST;
    private EmergencyQueue emergencyQueue;
    private TreatmentStack treatmentStack;

    private Map<Integer, VisitLinkedList> patientVisitHistory;

    public HospitalSystem() {
        patientBST = new PatientBST();
        emergencyQueue = new EmergencyQueue();
        treatmentStack = new TreatmentStack();
        patientVisitHistory = new HashMap<>();
    }

    public void addPatient(Patient patient) {

        // Check whether patient already exists
        if (patientBST.search(patient.getPatientId()) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        patientBST.insert(patient);

        patientVisitHistory.put(
                patient.getPatientId(),
                new VisitLinkedList()
        );

        System.out.println("Patient registered successfully.");
    }

    public Patient findPatient(int patientId) {
        return patientBST.search(patientId);
    }

    public void deletePatient(int patientId) {

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient ID not found.");
            return;
        }

        patientBST.delete(patientId);

        patientVisitHistory.remove(patientId);

        System.out.println("Patient record removed from the system.");
    }

    public void displayAllPatients() {
        patientBST.inOrderTraversal();
    }

    public void addEmergencyPatient(int patientId) {

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient ID not found.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    public Patient callNextEmergencyPatient() {
        return emergencyQueue.dequeue();
    }

    public void displayEmergencyQueue() {
        emergencyQueue.displayQueue();
    }

    public boolean isEmergencyQueueEmpty() {
        return emergencyQueue.isEmpty();
    }

    public void addTreatment(TreatmentRecord record) {
        treatmentStack.push(record);
    }

    public TreatmentRecord removeLatestTreatment() {
        return treatmentStack.pop();
    }

    public void displayTreatmentHistory() {
        treatmentStack.displayStack();
    }

    public boolean isTreatmentHistoryEmpty() {
        return treatmentStack.isEmpty();
    }

    public void addVisit(int patientId, Visit visit) {

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient ID not found.");
            return;
        }

        VisitLinkedList history
                = patientVisitHistory.get(patientId);

        if (history == null) {
            history = new VisitLinkedList();

            patientVisitHistory.put(
                    patientId,
                    history
            );
        }

        history.addVisit(visit);

        System.out.println(
                "Visit added to "
                + patient.getPatientName()
                + "'s history."
        );
    }

    public void removeVisit(int patientId, int visitId) {

        VisitLinkedList history
                = patientVisitHistory.get(patientId);

        if (history == null || history.isEmpty()) {
            System.out.println("Visit history is empty.");
            return;
        }

        history.removeVisit(visitId);
    }

    public Visit searchVisit(int patientId, int visitId) {

        VisitLinkedList history
                = patientVisitHistory.get(patientId);

        if (history == null) {
            return null;
        }

        return history.searchVisit(visitId);
    }

    public void displayVisitHistory(int patientId) {

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient ID not found.");
            return;
        }

        System.out.println(
                "\nVisit History for: "
                + patient.getPatientName()
        );

        VisitLinkedList history
                = patientVisitHistory.get(patientId);

        if (history == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        history.displayVisitHistory();
    }

    public int getWaitingPatientCount() {
        return emergencyQueue.getSize();
    }

    public int getCompletedTreatmentCount() {
        return treatmentStack.getSize();
    }

    public int getPatientCount() {
        return patientVisitHistory.size();
    }
}
