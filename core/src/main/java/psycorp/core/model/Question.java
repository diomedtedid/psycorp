package psycorp.core.model;

import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Scale;

import java.util.Locale;

/**
 * Created by User on 12.11.2017.
 * Реализует абстракцию вопроса теста.
 * Содержание полей класа зависит от того, какой язык и какое поле было выбранно
 */
public class Question {
    private Scale scale;
    private String value;
    private Area area;
    private Locale locale;

    public Question(Area area, Locale locale, Scale scale, String value) {
        this.area = area;
        this.scale = scale;
        this.value = value;
        this.locale = locale;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (scale != question.scale) return false;
        if (area != question.area) return false;
        return locale.equals(question.locale);
    }

    @Override
    public int hashCode() {
        int result = scale.hashCode();
        result = 31 * result + area.hashCode();
        result = 31 * result + locale.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "scale=" + scale +
                ", value='" + value + '\'' +
                ", area=" + area +
                ", locale=" + locale +
                '}';
    }
}
