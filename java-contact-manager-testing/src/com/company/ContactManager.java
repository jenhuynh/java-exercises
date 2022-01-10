package com.company;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//ContactManager is responsible to store the contact information and contains the main business logic to maintain contact information
public class ContactManager {
    //storing contact information inside the map
    Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();

    //addContact method takes the first and last name as input parameters and then storing information
        //in memory using a concurrent hash map
        //using concurrent hashmap because it's a thread safe implementation of the map interface
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        validateContact(contact);
        checkIfContactAlreadyExist(contact);
        contactList.put(generateKey(contact), contact);
    }

    //getAllContacts reads all the contacts present inside the map
    public Collection<Contact> getAllContacts() {
        return contactList.values();
    }

    //checkIfContactAlreadyExist is checking whether the contact already exists or not
    private void checkIfContactAlreadyExist(Contact contact) {
        if (contactList.containsKey(generateKey(contact)))
            throw new RuntimeException("Contact Already Exists");
    }

    //validateContact is validating the contact information of each field whether it is blank or not
        //aka not null or not empty and if the phone number should be exactly 10 digits in length
        //and should contain only digits, and it should start with 0
    //once all validation passes, we store them in memory
    private void validateContact(Contact contact) {
        contact.validateFirstName();
        contact.validateLastName();
        contact.validatePhoneNumber();
    }

    private String generateKey(Contact contact){
        return String.format("%s - %s", contact.getFirstName(), contact.getLastName());
    }
}
