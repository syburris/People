import java.io.*;
import java.util.*;

public class Main {

    static final String PEOPLE = "People.txt";
    public static HashMap<String, ArrayList<Person>> peopleMap = new HashMap<>();
    public static ArrayList<Person> people;
    public static String country;


    public static void main(String[] args) throws FileNotFoundException {
        people = readFile(PEOPLE);
        addToPeopleMap();
        for (String country : peopleMap.keySet()) {
            ArrayList<Person> personArrayList = new ArrayList<>();



        }
        System.out.println(peopleMap.get("France").toString());



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
    public static void addToPeopleMap() {
        for (Person person : people) {
            String country = person.getCountry();
            ArrayList<Person> peopleByCountry = peopleMap.get(country);
            if (peopleByCountry == null) {
                peopleByCountry = new ArrayList<>();
            }
            peopleByCountry.add(person);
            peopleMap.put(country,peopleByCountry);
        }
    }
}
