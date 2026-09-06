
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static HospitalSystem hospital = new HospitalSystem();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("==============================================");
        System.out.println("     MINI HOSPITAL EMERGENCY SYSTEM");
        System.out.println("==============================================");

        while (running) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    hospital.displayAllPatients();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    callNextPatient();
                    break;

                case 7:
                    hospital.displayEmergencyQueue();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    removeLatestTreatment();
                    break;

                case 10:
                    hospital.displayTreatmentHistory();
                    break;

                case 11:
                    addPatientVisit();
                    break;

                case 12:
                    removePatientVisit();
                    break;

                case 13:
                    searchPatientVisit();
                    break;

                case 14:
                    displayPatientVisitHistory();
                    break;

                case 0:
                    running = false;
                    System.out.println("\nThank you for using the system.");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n==============================================");
        System.out.println("              MAIN MENU");
        System.out.println("==============================================");
        System.out.println(" 1. Register New Patient");
        System.out.println(" 2. Search Patient");
        System.out.println(" 3. Delete Patient");
        System.out.println(" 4. Display All Patients");
        System.out.println("----------------------------------------------");
        System.out.println(" 5. Add Patient to Emergency Queue");
        System.out.println(" 6. Call Next Emergency Patient");
        System.out.println(" 7. Display Emergency Queue");
        System.out.println("----------------------------------------------");
        System.out.println(" 8. Add Completed Treatment");
        System.out.println(" 9. Remove Latest Treatment");
        System.out.println("10. Display Treatment History");
        System.out.println("----------------------------------------------");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Remove Patient Visit");
        System.out.println("13. Search Patient Visit");
        System.out.println("14. Display Patient Visit History");
        System.out.println("----------------------------------------------");
        System.out.println(" 0. Exit");
        System.out.println("==============================================");
    }

    private static void registerPatient() {

        System.out.println("\n========== REGISTER NEW PATIENT ==========");

        int id = readInt("Enter Patient ID: ");

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        int age = readInt("Enter Age: ");

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id,
                name,
                age,
                contact,
                condition
        );

        hospital.addPatient(patient);
    }

    private static void searchPatient() {

        System.out.println("\n========== SEARCH PATIENT ==========");

        int id = readInt("Enter Patient ID: ");

        Patient patient = hospital.findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("\nPatient found:");
            System.out.println("--------------------------------");
            patient.displayPatient();
            System.out.println("--------------------------------");
        }
    }

    private static void deletePatient() {

        System.out.println("\n========== DELETE PATIENT ==========");

        int id = readInt("Enter Patient ID: ");

        hospital.deletePatient(id);
    }

    private static void addEmergencyPatient() {

        System.out.println("\n========== EMERGENCY QUEUE ==========");

        int id = readInt("Enter Patient ID: ");

        hospital.addEmergencyPatient(id);
    }

    private static void callNextPatient() {

        System.out.println("\n========== NEXT EMERGENCY PATIENT ==========");

        Patient patient = hospital.callNextEmergencyPatient();

        if (patient != null) {

            System.out.println("\nPatient called for treatment:");
            System.out.println("--------------------------------");

            patient.displayPatient();

            System.out.println("--------------------------------");
        }
    }

    private static void addTreatment() {

        System.out.println("\n========== ADD COMPLETED TREATMENT ==========");

        int treatmentId = readInt("Enter Treatment ID: ");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = hospital.findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        System.out.print("Enter Treatment Date: ");
        String date = scanner.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                treatmentId,
                patientId,
                patient.getPatientName(),
                doctor,
                diagnosis,
                treatment,
                date
        );

        hospital.addTreatment(record);
    }

    private static void removeLatestTreatment() {

        System.out.println("\n========== REMOVE LATEST TREATMENT ==========");

        TreatmentRecord record
                = hospital.removeLatestTreatment();

        if (record != null) {
            System.out.println("\nRemoved treatment:");
            record.displayTreatment();
        }
    }

    private static void addPatientVisit() {

        System.out.println("\n========== ADD PATIENT VISIT ==========");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = hospital.findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID: ");

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        hospital.addVisit(patientId, visit);
    }

    private static void removePatientVisit() {

        System.out.println("\n========== REMOVE PATIENT VISIT ==========");

        int patientId = readInt("Enter Patient ID: ");

        int visitId = readInt("Enter Visit ID: ");

        hospital.removeVisit(patientId, visitId);
    }

    private static void searchPatientVisit() {

        System.out.println("\n========== SEARCH PATIENT VISIT ==========");

        int patientId = readInt("Enter Patient ID: ");

        int visitId = readInt("Enter Visit ID: ");

        Visit visit
                = hospital.searchVisit(patientId, visitId);

        if (visit == null) {
            System.out.println("Visit not found.");
        } else {

            System.out.println("\nVisit found:");
            System.out.println("--------------------------------");

            visit.displayVisit();

            System.out.println("--------------------------------");
        }
    }

    private static void displayPatientVisitHistory() {

        System.out.println("\n========== PATIENT VISIT HISTORY ==========");

        int patientId = readInt("Enter Patient ID: ");

        hospital.displayVisitHistory(patientId);
    }

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}
