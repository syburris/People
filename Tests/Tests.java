import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by stevenburris on 9/26/16.
 */
public class Tests {
    public static ArrayList<Person> people = new ArrayList<>();
    @Test
    public void testReadFile() throws FileNotFoundException {
        // Given
        //ArrayList<Person> people = new ArrayList<>();
        File file = new File("People.txt");
        Scanner fileScanner = null;

        // When
        fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");
            Person person = new Person(Integer.valueOf(columns[0]),columns[1],columns[2],columns[3],columns[4],columns[5]);
            people.add(person);
        }


        // Then
        assertTrue(!people.isEmpty());
        assertTrue(people.get(0).getClass().equals(Person.class));

    }

    @Test
    public void testAddPeopleMap() {

        // Given
        HashMap<String, ArrayList<Person>> peopleMap = new HashMap<>();
        ArrayList<Person> peopleByCountry = null;

        // If
        for (Person person : people) {
            String country = person.getCountry();
            peopleByCountry = peopleMap.get(country);
            if (peopleByCountry == null) {
                peopleByCountry = new ArrayList<>();

            }
            peopleByCountry.add(person);
            peopleMap.put(country,peopleByCountry);
        }
        //Then
    }


}
