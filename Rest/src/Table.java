import java.util.ArrayList;
import java.util.List;

public class Table {
    private TableStatus status;
    private String tableId;
    private List<Order> tableOrder = new ArrayList<>();

    public Table(TableStatus status, String tableId, List<Order> tableOrder) {
        this.status = status;
        this.tableId = tableId;
        this.tableOrder = tableOrder;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public List<Order> getTableOrder() {
        return tableOrder;
    }

    public void setTableOrder(List<Order> tableOrder) {
        this.tableOrder = tableOrder;
    }

    @Override
    public String toString() {
        return "Столик{" +
                "статус=" + status +
                ", номер='" + tableId + '\'' +
                ", заказы=" + tableOrder +
                '}';
    }
}
