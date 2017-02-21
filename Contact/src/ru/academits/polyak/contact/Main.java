package ru.academits.polyak.contact;

import ru.academits.polyak.contact.main.Contact;

public class Main {
    public static void main(String[] args) {
        Contact contactVasya = new Contact("Vasilii", "Ivanov", "123");
        System.out.println(contactVasya.getName());
        System.out.println(contactVasya.getSurname());
        System.out.println(contactVasya.getPhoneNumber());

        contactVasya.setName("Vasya");
        System.out.println(contactVasya.getName());
        contactVasya.setSurname("Vasechkin");
        System.out.println(contactVasya.getSurname());
        contactVasya.setPhoneNumber("121212");
        System.out.println(contactVasya.getPhoneNumber());
    }
}
