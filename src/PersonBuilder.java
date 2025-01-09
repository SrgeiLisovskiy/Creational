public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    private boolean ageEmpty = false;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Возраст не может быть больше 120 и меньше 0");
        }
        this.age = age;
        ageEmpty = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Введите имя и фамилию");
        }
        Person person;
        if (ageEmpty) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(address);
        person.setAgeEmpty(ageEmpty);
        return person;
    }
}
