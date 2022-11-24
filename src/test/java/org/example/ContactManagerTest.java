package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContactManagerTest {

    ContactManager contactManager;

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Deve imprimir antes de todos os testes");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Criando um contact manager");
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Deve criar um contacto:")
    public void criarContacto(){
        contactManager.addContact("Andre","Barbosa","0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1,contactManager.getAllContacts().size());
    }

    @Test
    @DisplayName("Não deve criar um contacto com o primeiro nome nulo")
    public void pNomeNaoNulo(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            contactManager.addContact(null,"Barbosa","0123456789");});
    }

    @Test
    @DisplayName("Não deve criar um contacto com o ultimo nome nulo")
    public void uNomeNaoNulo(){
        Assertions.assertThrows(RuntimeException.class,()->{
        contactManager.addContact("Andre",null,"0123456789");});
    }

    @Test
    @DisplayName("Não deve criar um contacto com o contacto nulo")
    public void contactoNaoNulo(){
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Andre","Barbosa",null);});
    }

    @Test
    @DisplayName("Contacto deve começar com 0")
    public void comecarComZero(){
        contactManager.addContact("Andre","Barbosa","0123456789");
        assertEquals(1,contactManager.getAllContacts().size());
    }

    @Nested
    class RepetirTestes {
        @DisplayName("Repetir a criação de um contacto 5 vezes")
        @RepeatedTest(value = 5)
        public void repTesteCriarContacto() {
            contactManager.addContact("John", "Doe","0123456789");
            assertFalse(contactManager.getAllContacts().isEmpty());
            assertEquals(1,contactManager.getAllContacts().size());
        }
    }

    @Nested
    class ParameterizedTests {
        @DisplayName("Phone Number should match the required Format")
        @ParameterizedTest
        @ValueSource(strings = {"0123456789", "0123456798", "0123456897"})
                public void shouldTestPhoneNumberFormatUsingValueSource(String phoneNumber)
        {
            contactManager.addContact("John", "Doe",phoneNumber);
            assertFalse(contactManager.getAllContacts().isEmpty());
            assertEquals(1,contactManager.getAllContacts().size());
        }
    }
    @DisplayName("Method Source Case - Phone Number should match the required Format")
            @ParameterizedTest
            @MethodSource("phoneNumberList")
            public void
            shouldTestPhoneNumberFormatUsingMethodSource(String phoneNumber)
    {
        contactManager.addContact("John", "Doe", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }
    private static List<String> phoneNumberList() {
        return Arrays.asList("0123456789", "0123456798", "0123456897");
    }
    @Test
    @DisplayName("Test Should Be Disabled")
    @Disabled
    public void shouldBeDisabled() {
        throw new RuntimeException("Test Should Not be executed");
    }
    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }
    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }
}
