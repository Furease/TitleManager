package titlemanager.model;

/**
 * Class Item untuk menyimpan data item secara sementara.
 * 
 * @author Fure
 */
public class Item {
    private int     value;              // nilai item atau ID item
    private String  description;        // deskripsi item

    public Item(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public Item() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
