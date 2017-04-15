package ru.success.MyFirstServer.service;

import ru.success.MyFirstServer.entity.Remind;

import java.util.List;

/*Здесь определим все методы , которые нам необходимы*/
public interface ReminderService {
    List<Remind> getAll(); // метод возвращает список

    Remind getByID(long id);// возвращает один объект 

    Remind save(Remind remind);// сохраняет объекты

    void remove(long id);// удаляем по id
}
