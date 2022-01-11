package com.company;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

//creates only one instance of the class, instantiates the test class only once
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ContactManagerTest {

    //create instance contactManager variable
    private ContactManager contactManager;

    //method marked with @BeforeAll will be executed once for the entire test class, usually occurs before the instance of the test
        //mark as static or junit cannot execute this method
    @BeforeAll
    public static void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    //setUp method to initialize contactManager class/object as it is redundant if we keep writing for each test method
        //Junit will create a new instance of the class for each method so each test will work with its own copy
    @BeforeEach
    public void setup(){
        //create object for the contact manager class
         contactManager = new ContactManager();
    }

    //testing that a contact is created successfully and saved to the application
    @Test
    //@DisplayName annotation provides a custom readable name for this method/test so instead of displaying the method name, it displays the custom name
    @DisplayName("Should Create Contact")
    public void shouldCreateContact() {
        //call addContact method and create a contact and pass it in first, last, and phone number details
        contactManager.addContact("John", "Doe", "0123456789");
        //verify if the list is not empty, using assert false method so this will take a boolean parameter as input and if
        //boolean is not false, it will throw an exception and will fail the test
        //we expect this list from get all contacts methods should not be empty, use assertfalse method
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //testing to verify if the result of getAllContacts() is not empty, the size of getAllContacts() is exactly 1
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equals("John") &&
                        contact.getLastName().equals("Doe") &&
                        contact.getPhoneNumber().equals("0123456789"))
                .findAny()
                .isPresent());
    }

    //tests whether the Contact Creation fails when we enter the First Name as Null
    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
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
        Assertions.assertThrows(RuntimeException.class, () -> {
           contactManager.addContact("John", null, "0123456789");
        });
    }

    //tests whether the Contact Creation fails when Phone Number is Null
    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", "Doe", null);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }

    //testing that a contact is created successfully and saved to the application only on MAC OS
    @Test
    //@DisplayName annotation provides a custom readable name for this method/test so instead of displaying the method name, it displays the custom name
    @DisplayName("Should Create Contact Only on MAC OS")
    @EnabledOnOs(value = OS.MAC, disabledReason = "Should Run only on MAC OS")
    public void shouldCreateContactOnlyOnMAC() {
        //call addContact method and create a contact and pass it in first, last, and phone number details
        contactManager.addContact("John", "Doe", "0123456789");
        //verify if the list is not empty, using assert false method so this will take a boolean parameter as input and if
        //boolean is not false, it will throw an exception and will fail the test
        //we expect this list from get all contacts methods should not be empty, use assertfalse method
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //testing to verify if the result of getAllContacts() is not empty, the size of getAllContacts() is exactly 1
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equals("John") &&
                        contact.getLastName().equals("Doe") &&
                        contact.getPhoneNumber().equals("0123456789"))
                .findAny()
                .isPresent());
    }
    //testing that a contact is created successfully and saved to the application only on Windows OS
    @Test
    //@DisplayName annotation provides a custom readable name for this method/test so instead of displaying the method name, it displays the custom name
    @DisplayName("Should Create Contact Only on Windows OS")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Should Run Only on Windows OS")
    public void shouldCreateContactOnlyOnWindows() {
        //call addContact method and create a contact and pass it in first, last, and phone number details
        contactManager.addContact("John", "Doe", "0123456789");
        //verify if the list is not empty, using assert false method so this will take a boolean parameter as input and if
        //boolean is not false, it will throw an exception and will fail the test
        //we expect this list from get all contacts methods should not be empty, use assertfalse method
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //testing to verify if the result of getAllContacts() is not empty, the size of getAllContacts() is exactly 1
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equals("John") &&
                        contact.getLastName().equals("Doe") &&
                        contact.getPhoneNumber().equals("0123456789"))
                .findAny()
                .isPresent());
    }

    @Test
    @DisplayName("Test Contact Creation on Developer Machine")
    public void shouldTestContactCreationOnDEV() {
        //property set called ENV inside the run configurations
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        contactManager.addContact("John","Doe","0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @DisplayName("Repeat Contact Creation Test 5 Times")
    @RepeatedTest(value = 5,
            name = "Repeating Contact Creation Test {currentRepetition} of {totalRepetitions}")
    public void shouldTestContactCreationRepeatedly() {
        contactManager.addContact("John", "Doe", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @DisplayName("Repeat Contact Creation Test 5 Times")
    @ParameterizedTest
    @ValueSource (strings = {"0123456789", "0123456789", "0123456789"})
    public void shouldTestContactCreationUsingValueSource(String phoneNumber) {
         contactManager.addContact("John", "Doe", phoneNumber);
         assertFalse(contactManager.getAllContacts().isEmpty());
         assertEquals(1, contactManager.getAllContacts().size());
    }

    @DisplayName("Method Source Case - Phone Number should match the required Format")
    @ParameterizedTest
    //Junit will dynamically read the fdata returned from the phoneNumberList method and will inject them into tests
    @MethodSource("phoneNumberList")
    public void shouldTestPhoneNumberFormatUsingMethodSource(String phoneNumber) {
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    private static List<String> phoneNumberList() {
        return Arrays.asList("0123456789", "0123456798", "0123456897");
    }

    @DisplayName("CSV Source Case - Phone Number should match the required Format")
    @ParameterizedTest
    //Junit will dynamically read the fdata returned from the phoneNumberList method and will inject them into tests
    @CsvSource({"0123456789", "0123456798", "0123456897"})
    public void shouldTestPhoneNumberFormatUsingCSVSource(String phoneNumber) {
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @Nested
    class RepeatedNestedTest {

    }

    class ParameterizedNestedTest {

    }
}