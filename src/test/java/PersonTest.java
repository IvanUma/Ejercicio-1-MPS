import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

    Person person;

    @Test
    void personWithNegativeAge(){
        assertThrows(IncorrectPersonException.class, () -> new Person("name", -3, "Male"));
    }

    @Test
    void personWithExcesiveAge(){
        assertThrows(IncorrectPersonException.class, () -> new Person("name", 200, "Male"));
    }
    @Test
    void personWithIncorrectGender(){
        assertThrows(IncorrectPersonException.class, () -> new Person("name", 10, "IncorrectGender"));
    }

    @Test
    void getNameShouldReturnCorrectName(){
        String name = "name";
        person = new Person(name, 10, "Female");
        assertEquals(person.name(), name);
    }

    @Test
    void getAgeShouldReturnCorrectAge(){
        int age = 10;
        person = new Person("name", age, "Female");
        assertEquals(person.age(), age);
    }

    @Test
    void getGenderShouldReturnCorrectGender(){
        String gender = "Female";
        person = new Person("name", 10, gender);
        assertEquals(person.gender(), gender);
    }

    @Test
    void averageOfAnEmptyListIsZero(){
        double[] expectedValue = new double[2];
        expectedValue[0] = 0;
        expectedValue[1] = 0;
        List<Person> persons = new ArrayList<>();
        person = new Person("name", 10, "Female");
        double[] obtainedValue = person.averageAgePerGender(persons);
        //Comparamos la media de los hombres
        assertEquals(obtainedValue[0], expectedValue[0]);

        //Comparamos la media de las mujeres
        assertEquals(obtainedValue[1], expectedValue[1]);
    }

    @Test
    void averageOfAListWithElements(){
        double[] expectedValue = new double[2];
        expectedValue[0] = 35;
        expectedValue[1] = 25;
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("Person1", 20, "Male");
        Person person2 = new Person("Person2", 50, "Male");
        Person person3 = new Person("Person3", 10, "Female");
        Person person4 = new Person("Person4", 40, "Female");
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        double[] obtainedValue = person1.averageAgePerGender(persons);

        //Comparamos la media de los hombres
        assertEquals(obtainedValue[0], expectedValue[0]);

        //Comparamos la media de las mujeres
        assertEquals(obtainedValue[1], expectedValue[1]);
    }

    @Test
    void averageOfAListWithOneGender(){
        double[] expectedValue = new double[2];
        expectedValue[0] = 30;
        expectedValue[1] = 0;
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("Person1", 20, "Male");
        Person person2 = new Person("Person2", 50, "Male");
        Person person3 = new Person("Person3", 10, "Male");
        Person person4 = new Person("Person4", 40, "Male");
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        double[] obtainedValue = person1.averageAgePerGender(persons);

        //Comparamos la media de los hombres
        assertEquals(obtainedValue[0], expectedValue[0]);

        //Comparamos la media de las mujeres
        assertEquals(obtainedValue[1], expectedValue[1]);
    }
}
