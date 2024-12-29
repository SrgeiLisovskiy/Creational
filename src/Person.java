import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String address;
    private boolean ageEmpty;

    public Person(String name, String surname, int age) {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Введите имя и фамилию");
        } else if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Возраст не может быть больше 120 и меньше 0");
        }
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname) {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Введите имя и фамилию");
        }
        this.name = name;
        this.surname = surname;
    }


    public boolean hasAge() {
        return ageEmpty;
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        }
        return true;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAge(0).setAddress(this.address);
    }


    public void happyBirthday() {
        if (ageEmpty) {
            this.age += 1;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    protected void setAgeEmpty(boolean ageEmpty) {
        this.ageEmpty = ageEmpty;
    }


}