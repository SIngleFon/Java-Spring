package maven.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static maven.project.Person.JSON_FILE;

public class Main {
    public static void main(String[] args) {
        //Инициализация 2х персон
        Person person = new Person("Timur", "Muminov", 22);
        Person person1 = new Person("Timur", "Muminov1", 22);

        //Проверка метода toString() с использованием библиотеки Apache Commons Lang
        System.out.println(person);

        //Проверка метода equals() с использованием библиотеки Apache Commons Lang
        System.out.println(person.equals(person1));

        //Проверка метода hashCode() с использованием библиотеки Apache Commons Lang
        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());

        //Проверка сериализации и десериализации с использованием зависимости от GSON(google)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(person);
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            writer.write(json);
            System.out.println("Объект успешно сохранен в файл " + JSON_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Загрузка объекта из файла и десериализация JSON обратно в объект Person
        try (FileReader reader = new FileReader(JSON_FILE)) {
            Person deserializedPerson = gson.fromJson(reader, Person.class);
            System.out.println("Объект успешно загружен из файла:");
            System.out.println("Имя: " + deserializedPerson.getFirstName());
            System.out.println("Фамилия: "+ deserializedPerson.getLastName());
            System.out.println("Возраст: " + deserializedPerson.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}