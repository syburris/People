import jodd.json.JsonSerializer;

import java.io.*;
import java.util.*;

public class Main {

    static final String PEOPLE = "People.txt";


    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<Person>> peopleMap = new HashMap<>();
        ArrayList<Person> people = readFile();
        addToPeopleMap(people,peopleMap);

        for (String country : peopleMap.keySet()) {
            ArrayList<Person> personArrayList = peopleMap.get(country);
            Collections.sort(personArrayList);
        }
        System.out.println(peopleMap);
        File peopleJson = new File("people.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(peopleMap);
        FileWriter writeJson = new FileWriter(peopleJson);
        writeJson.append(json);
        writeJson.close();



    }
    public static ArrayList<Person> readFile() throws FileNotFoundException {
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
    public static void addToPeopleMap(ArrayList<Person> people, HashMap<String, ArrayList<Person>> peopleMap) {
        ArrayList<Person> peopleByCountry = null;
        for (Person person : people) {
            String country = person.getCountry();
            peopleByCountry = peopleMap.get(country);
            if (peopleByCountry == null) {
                peopleByCountry = new ArrayList<>();

            }
            peopleByCountry.add(person);
            peopleMap.put(country,peopleByCountry);
        }
        //Collections.sort(peopleByCountry);
    }
}
