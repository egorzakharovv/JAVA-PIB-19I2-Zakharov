import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
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
        System.out.println("Столики: ");
        restaurant.printTable();
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
        System.out.println("\nМеню:");
        restaurant.printMenu();

        restaurant.makeOrder(2, "A2", "Позажаристее, пожалуйста");
        restaurant.makeOrder(4, "A2");
        restaurant.makeOrder(5, "A2");
        restaurant.makeOrder(6, "A2");
        restaurant.changeShift(1);
        restaurant.pay("A2");
        System.out.println(restaurant);
    }
}
