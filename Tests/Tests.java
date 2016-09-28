
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by stevenburris on 9/26/16.
 */
public class Tests {
    @Test
    public void testReadFile() throws FileNotFoundException {
        ArrayList<Person> people = Main.readFile();

        // Then
        assertTrue(!people.isEmpty());
        assertTrue(people.get(0).getClass().equals(Person.class));

    }

    @Test
    public void testAddPeopleMap() throws FileNotFoundException {

        // Given
        HashMap<String, ArrayList<Person>> peopleMap = new HashMap<>();
        ArrayList<Person> people = Main.readFile();

        // If

        Main.addToPeopleMap(people,peopleMap);
        //Then
        assertTrue(!peopleMap.isEmpty());
    }

    @Test
    public void testWriteJson() throws IOException {
        // Given
        HashMap<String, ArrayList<Person>> peopleMap = new HashMap<>();
        ArrayList<Person> people = Main.readFile();
        Main.addToPeopleMap(people,peopleMap);
        File file = new File("people.json");

        // If
        Main.writeJson(peopleMap);

        // Then
        assertTrue(file.exists());
    }

    @Test
    public void testSortPeople() throws FileNotFoundException {
        // Given
        HashMap<String, ArrayList<Person>> peopleMap = new HashMap<>();
        ArrayList<Person> people = Main.readFile();
        Main.addToPeopleMap(people, peopleMap);


        // If
        Main.sortPeople(peopleMap);

        // Then
        assertTrue(peopleMap.get("China").get(1).lastName.compareTo(peopleMap.get("China").get(2).lastName) < 0);

    }
}
