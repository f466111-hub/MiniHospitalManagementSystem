# Mini Hospital Emergency Management System

## Introduction

The Mini Hospital Emergency Management System is a Java console application. It is designed to manage patient records, emergency patients, treatment records, and patient visit history.

The main purpose of this project is to show how different data structures can be used to solve real-world hospital management problems.

## Data Structures Used

### 1. Binary Search Tree (BST)

A Binary Search Tree is used to store patient records.

Each patient has a unique Patient ID.

The system can:

* Add a patient
* Search for a patient using Patient ID
* Delete a patient
* Display all patients using in-order traversal

The in-order traversal displays patients in ascending order of Patient ID.

### 2. Queue

A Queue is used to manage emergency patients.

The system can:

* Add a patient to the queue
* Remove the next patient from the queue
* Display the emergency queue
* Check whether the queue is empty

The Queue follows the **FIFO (First In, First Out)** method. This means the patient who enters first will be called first.

### 3. Stack

A Stack is used to store completed treatment records.

The system can:

* Add a treatment record
* Remove the latest treatment record
* Display treatment history
* Check whether the stack is empty

The Stack follows the **LIFO (Last In, First Out)** method. This means the latest treatment record is removed first.

### 4. Singly Linked List

A separate Singly Linked List is used for each patient to store their previous hospital visits.

Each visit contains:

* Visit ID
* Visit date
* Doctor
* Diagnosis
* Treatment

The system can:

* Add a visit
* Remove a visit
* Search for a visit
* Display visit history

## Project Structure

```text
MiniHospitalManagementSystem/
│
├── src/
│   ├── Main.java
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentRecord.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   ├── VisitLinkedList.java
│   └── HospitalSystem.java
│
└── README.md
```

## Technologies Used

* Java
* Visual Studio Code
* Git
* GitHub

## How to Run

Open the terminal in the project folder.

Go to the `src` folder:

```bash
cd src
```

Compile the Java files:

```bash
javac *.java
```

Run the program:

```bash
java Main
```

## Main Features

The system has the following features:

1. Register a new patient
2. Search for a patient
3. Delete a patient
4. Display all patients
5. Add a patient to the emergency queue
6. Call the next emergency patient
7. Display the emergency queue
8. Add a completed treatment
9. Remove the latest treatment
10. Display treatment history
11. Add a patient visit
12. Remove a patient visit
13. Search for a patient visit
14. Display patient visit history
15. Exit the system

## Example

Patients can be registered with the following details:

* Patient ID
* Patient Name
* Age
* Contact Number
* Medical Condition

Example:

```text
101 | Fathima | 23 | 0771234567 | Fever
102 | Sara    | 25 | 0753456789 | Injury
105 | Ahmed   | 30 | 0712345678 | Headache
```

The BST displays these patients in ascending order of Patient ID.

## Data Structure Design

The project uses custom nodes to implement the main data structures.

* The BST uses nodes to store patient records.
* The Queue uses linked nodes with front and rear references.
* The Stack uses linked nodes with a top reference.
* The Singly Linked List uses nodes to store patient visit records.

These implementations help to show how the main data structures work instead of using Java's built-in data structure classes for the main operations.

## Testing

The following functions were tested:

* Adding patients
* Searching for patients
* Deleting patients
* Displaying patients in BST order
* Adding and removing emergency patients
* Checking an empty queue
* Adding and removing treatment records
* Checking an empty stack
* Adding patient visits
* Removing patient visits
* Searching patient visits
* Displaying patient visit history

All main operations were tested using the console application.

## Conclusion

This project shows how different data structures can be used in a hospital management system.

The Binary Search Tree is used for patient records and searching patients. The Queue is used to manage emergency patients using FIFO order. The Stack is used to manage treatment records using LIFO order. The Singly Linked List is used to store each patient's previous hospital visits.

This project also helped me improve my knowledge of Java, object-oriented programming, data structures, testing, Git, and GitHub.
