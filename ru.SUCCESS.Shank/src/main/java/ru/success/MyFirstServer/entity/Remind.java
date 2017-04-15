package ru.success.MyFirstServer.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/*для одной сущности один репозиторий */
@Entity
@Table(name = "remind")// имя нашей бд
public class Remind {

    /*то что мы будем передавать в наше приложение*/
    @Id
    /*указываем , чтобы наше поле id автоинкрементилось(Суррога́тный ключ — понятие теории реляционных баз данных.
Это дополнительное служебное поле, добавленное к уже имеющимся информационным полям таблицы, единственное предназначение которого — служить первичным ключом.
Значение этого поля не образуется на основе каких-либо других данных из БД, а генерируется искусственно.)*/
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "title",nullable = false,length = 50) // название колонки нашей бд, второе свойство означает, что данные колонки не должны быть пустыми, третие поле -сколько символов может включать данная колонка
    private String title;

    @Column(name = "remind_date",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date remindDate;

    /*конструктор пустой*/
    public Remind() {
    }

    /*geter and seter*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }
}
