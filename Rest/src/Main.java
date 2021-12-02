import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    Restaurant restaurant;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        File file = new File("data.txt");
        if (!file.exists()) {
            System.out.println("Файла нет, создаём данные");
            main.init();
            Gson gson = new Gson();
            Files.write( Paths.get("data.txt"), gson.toJson(main.restaurant).getBytes());
        } else {
            System.out.println("Читаем файл, извлекаем данные");
            Gson gson = new Gson();
            String text = new String(Files.readAllBytes(Paths.get("data.txt")), StandardCharsets.UTF_8);
            main.restaurant = gson.fromJson(text, Restaurant.class);
        }
        System.out.println("Столики: ");
        main.restaurant.printTable();
        System.out.println("\nМеню:");
        main.restaurant.printMenu();
        System.out.println(main.restaurant);
    }

    void init() {
        restaurant = new Restaurant();
        restaurant.addShift("Смена A");
        restaurant.addShift("Смена B");
        restaurant.changeShift(0);
        List<Table> tableList = new ArrayList<>();
        tableList.add(new Table(TableStatus.FREE, "A1", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "A2", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "A3", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "A4", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "A5", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "A6", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "A7", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "A8", new ArrayList<>()));
        restaurant.setTables(tableList);
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Утка", 599));
        menu.add(new Dish("Гусь", 900));
        menu.add(new Dish("Курица", 499));
        menu.add(new Dish("Виноград", 399));
        menu.add(new Dish("Суп из форели", 259));
        menu.add(new Dish("Фрикадельки", 159));
        menu.add(new Dish("Хлеб", 9));
        menu.add(new Dish("Баскет \"Нежный\"", 349));
        menu.add(new Dish("Баскет \"Острый\"", 359));
        restaurant.setMenu(menu);


        restaurant.makeOrder(2, "A2", "Позажаристее, пожалуйста");
        restaurant.makeOrder(4, "A2");
        restaurant.makeOrder(5, "A2");
        restaurant.makeOrder(6, "A2");
        restaurant.changeShift(1);
        restaurant.pay("A2");
    }
}
