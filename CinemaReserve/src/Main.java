import com.ferdynan.cinemareserve.persistence.entity.AgeCategory;
import com.ferdynan.cinemareserve.persistence.entity.impl.Film;
import com.ferdynan.cinemareserve.persistence.entity.impl.User;
import com.ferdynan.cinemareserve.persistence.exception.EntityArgumentException;
import com.ferdynan.cinemareserve.util.LocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;




public class Main {
    public static void main(String[] args) {

        try{

            UUID userId = UUID.randomUUID();

            User ferdynand = new User("Ferdinand", "p23456789", LocalDate.of(2000, 1, 1), "ferdynand@example.com", userId );
            Duration filmDuration = Duration.ofHours(2).plusMinutes(30);

            // Створення об'єкта фільму
//            Film exampleFilm = new Film("Прикладний Фільм", filmDuration, AgeCategory.ALL_AGES, "Драма", "США");
            System.out.println(ferdynand);
            List<User> users = new ArrayList<>();
            users.add(ferdynand);

            writeUsersToJsonFile(users,"Users.json");


        }catch (EntityArgumentException e) {
            List<String> errors = e.getErrors();
            for (String error : errors) {
                System.out.println("Error: " + error);
            }
        }


    }
    public static void writeUsersToJsonFile(List<User> users, String fileName){
        try(FileWriter writer = new FileWriter(fileName)){
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                    .setPrettyPrinting().create();

            // Перетворюємо колекцію користувачів в JSON та записуємо у файл
            gson.toJson(users, writer);

            System.out.println("Колекцію користувачів збережено в файл " + fileName);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}