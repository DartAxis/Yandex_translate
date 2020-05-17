package ru.dartinc.Yandex_translate.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "text", nullable = false)
    String text;

    @Column(name = "translatefrom", nullable = false)
    String translateFrom;

    @Column(name = "translateto", nullable = false)
    String translateTo;

    @Column(name = "result")
    String result;

    public Item() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslateFrom() {
        return translateFrom;
    }

    public void setTranslateFrom(String translateFrom) {
        this.translateFrom = translateFrom;
    }

    public String getTranslateTo() {
        return translateTo;
    }

    public void setTranslateTo(String translateTo) {
        this.translateTo = translateTo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return text.equals(item.text) &&
                translateFrom.equals(item.translateFrom) &&
                translateTo.equals(item.translateTo) &&
                Objects.equals(result, item.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, translateFrom, translateTo, result);
    }

    @Override
    public String toString() {
        return "Item{" +
                "text='" + text + '\'' +
                ", translateFrom='" + translateFrom + '\'' +
                ", translateTo='" + translateTo + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
