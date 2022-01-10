package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ContactManagerTest {

    //testing that a contact is created successfully and saved to the application
    @Test
    //@DisplayName annotation provides a custom readable name for this method/test so instead of displaying the method name, it displays the custom name
    @DisplayName("Should Create Contact")
    public void shouldCreateContact() {
        //create object for the contact manager class
        ContactManager contactManager = new ContactManager();
        //call addContact method and create a contact and pass it in first, last, and phone number details
        contactManager.addContact("John", "Doe", "0123456789");
        //verify if the list is not empty, using assert false method so this will take a boolean parameter as input and if
        //boolean is not false, it will throw an exception and will fail the test
        //we expect this list from get all contacts methods should not be empty, use assertfalse method
        assertFalse(contactManager.getAllContacts().isEmpty());
        //testing to verify if the result of getAllContacts() is not empty, the size of getAllContacts() is exactly 1
        assertEquals(1, contactManager.getAllContacts().size());
    }

    //tests whether the Contact Creation fails when we enter the First Name as Null
    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        ContactManager contactManager = new ContactManager();
        //asserting that the addContact() method throws a RuntimeException
        //assert the Exceptions using the assertThrow() method from the Assertions class
        //assertThrow() method takes the Exception Type as the first parameter and the Executable which throws the Exception as the second parameter
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Doe", "0123456789");
        });
    }

    //tests whether the Contact Creation fails when we enter the Last Name as Null
    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
           contactManager.addContact("John", null, "0123456789");
        });
    }

    //tests whether the Contact Creation fails when Phone Number is Null
    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", "Doe", null);
        });
    }
}