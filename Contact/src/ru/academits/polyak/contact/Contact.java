package ru.academits.polyak.contact;

class Contact {
    private String name;
    private String surname;
    private int phoneNumber;

    public Contact(String name, String surname, int phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String newSername) {
        surname = newSername;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }
}
