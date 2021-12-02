import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements PaymentSystem{
    private List<String> shifts;
    private List<Table> tables;
    private List<Order> orderList;
    private List<Dish> menu;
    private String currentShift;

    Restaurant() {
        shifts = new ArrayList<>();
        tables = new ArrayList<>();
        orderList = new ArrayList<>();
        menu = new ArrayList<>();
        currentShift = "";
    }

    public void printMenu() {
        for (Dish dish : menu) {
            System.out.println(dish);
        }
    }

    public void addShift(String shift) {
        shifts.add(shift);
    }

    public void changeShift(int index) {
        if (index < 0 || index >= shifts.size()) {
            System.out.println("Смена не найдена");
        } else {
            System.out.println("Смена " + currentShift + " сменяется на " + shifts.get(index));
            currentShift = shifts.get(index);
        }
    }

    public void makeOrder(Order order, String table) {
        for (Table table1 : tables) {
            if (table1.getTableId().equalsIgnoreCase(table)) {
                    table1.setStatus(TableStatus.BUSY);
                    table1.getTableOrder().add(order);
                    orderList.add(order);
                System.out.println("Сделан заказ на столик " + table + ", " + order);
            }
        }
    }

    public void makeOrder(int menuIndex, String table) {
        if (menuIndex < 0 || menuIndex >= menu.size()) {
            System.out.println("Индекс неверно указан");
        } else {
            for (Table table1 : tables) {
                if (table1.getTableId().equalsIgnoreCase(table)) {
                    table1.setStatus(TableStatus.BUSY);
                    table1.getTableOrder().add(new Order(menu.get(menuIndex), menu.get(menuIndex).getPrice(), ""));
                    orderList.add(new Order(menu.get(menuIndex), menu.get(menuIndex).getPrice(), ""));
                    System.out.println("Сделан заказ на столик " + table + ", " + orderList.get(orderList.size() - 1));
                }
            }
        }
    }

    public void makeOrder(int menuIndex, String table, String description) {
        if (menuIndex < 0 || menuIndex >= menu.size()) {
            System.out.println("Индекс неверно указан");
        } else {
            for (Table table1 : tables) {
                if (table1.getTableId().equalsIgnoreCase(table)) {
                    table1.setStatus(TableStatus.BUSY);
                    table1.getTableOrder().add(new Order(menu.get(menuIndex), menu.get(menuIndex).getPrice(), description));
                    orderList.add(new Order(menu.get(menuIndex), menu.get(menuIndex).getPrice(), description));
                    System.out.println("Сделан заказ на столик " + table + ", " + orderList.get(orderList.size() - 1));
                }
            }
        }
    }

    public void sitAtTable(String table) {
        for (Table table1 : tables) {
            if (table.equalsIgnoreCase(table1.getTableId())) {
                table1.setStatus(TableStatus.BUSY);
            }
        }
    }

    public void pay(String table) {
        for (Table table1 : tables) {
            if (table.equalsIgnoreCase(table1.getTableId())) {
                for (Order order : table1.getTableOrder()) {
                    order.setPaymentStatus(PaymentStatus.PAY);
                }
                System.out.println("Блюда оплачены");
            }
        }
    }

    public void reserveTable(String table) {
        for (Table table1 : tables) {
            if (table1.getTableId().equalsIgnoreCase(table)) {
                if (table1.getStatus() == TableStatus.FREE) {
                    table1.setStatus(TableStatus.RESERVED);
                } else {
                    System.out.println(table1 + " сейчас занят, невозможно зарезервировать");
                }
            }
        }
    }

    public void printTable() {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    public List<String> getShifts() {
        return shifts;
    }

    public void setShifts(List<String> shifts) {
        this.shifts = shifts;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public String getCurrentShift() {
        return currentShift;
    }

    @Override
    public String toString() {
        return "Ресторан{" +
                "\nсмены=" + shifts +
                ",\nстолики=" + tables +
                ",\nсписок заказов=" + orderList +
                ",\nменю=" + menu +
                ",\nтекущая смена=" + currentShift +
                '}';
    }
}
