package Models;

/**
 * Created by zalmangagerman on 11/10/17.
 */
public interface FactI extends SpecialEventI {
    String getText();
    int getId();
    void setId(int id);
    void setText(String text);
}
