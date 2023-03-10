import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Ivan Delgado Alba
 */

public class Person {

    private final String name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Constructs a person with a name, age and gender.
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */

    public Person(String name, int age, String gender){
        if(age < 0){
            throw new IncorrectPersonException("La edad no puede ser negativa");
        }else if(gender.compareToIgnoreCase("Female") != 0 && gender.compareToIgnoreCase("Male") != 0){
            throw new IncorrectPersonException("Genero incorrecto");
        }else if(age > 150){
            throw new IncorrectPersonException("Edad demasiado alta");
        } else{
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
    }

    public String name(){
        return name;
    }

    public int age(){
        return age;
    }

    public String gender(){
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in an array of two elements
     * (the first element is the male mean age and the second one is the female mean age)
     *
     * @param persons
     * @return result
     */
    public double[] averageAgePerGender(List<Person> persons){
        double[] result = new double[2];
        double males = 0, totalAgeMales = 0, females = 0, totalAgeFemales = 0;

        for(Person person : persons){
            if(person.gender().equals("Male")){
                males+=1;
                totalAgeMales+=person.age();
            }else{
                females+=1;
                totalAgeFemales+=person.age();
            }
        }
        if(males == 0){
            result[0] = 0;
        }else{
            result[0] = totalAgeMales / males;
        }
        if(females == 0){
            result[1] = 0;
        }else{
            result[1] = totalAgeFemales / females;
        }
        return result;
    }
}
