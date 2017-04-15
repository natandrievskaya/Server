package ru.success.MyFirstServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.success.MyFirstServer.entity.Remind;
import ru.success.MyFirstServer.repository.RemindRepository;

import java.util.List;

/**
 * сервисный слой , который предоставляет возможность работы с логикой приложения , с нашим ReminderController
 * Так глуппо работать с контролером напрямую. Потому, что мы можем иметь несколько репозитори.  И данная реализация просто упростит нам жизнь
 * Тут уже можно подключать наши репоситории.
 * Здесь мы реализуем всю бизнесс логику нашего приложения. А контролеры их просто вызывают
 */
@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private RemindRepository repository;

    /*реализация наших методов для работы с бд*/

    //получаем все записи
    public List<Remind> getAll() {
        return repository.findAll();
    }

    //получаем одну запись
    public Remind getByID(long id) {
        return repository.findOne(id);
    }

    //записываем(обновляем) наши объекты
    public Remind save(Remind remind) {
        return repository.saveAndFlush(remind);
    }

    //удаляем наши записи по id
    public void remove(long id) {
        repository.delete(id);
    }
}
