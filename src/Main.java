import jodd.json.JsonSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    static final String PEOPLE = "People.txt";
    public static HashMap<String, ArrayList<Person>> peopleMap = new HashMap<>();


    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Person> people = readFile(PEOPLE);
        System.out.println(people.toString());

    }
    public static ArrayList<Person> readFile(String peopleTextFile) throws FileNotFoundException {
        ArrayList<Person> people = new ArrayList<>();
        File file = new File(PEOPLE);
        Scanner fileScanner = null;
        fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");
            Person person = new Person(Integer.valueOf(columns[0]),columns[1],columns[2],columns[3],columns[4],columns[5]);
            people.add(person);
        }
        return people;
    }
}
