package ru.success.MyFirstServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.success.MyFirstServer.entity.Remind;
import ru.success.MyFirstServer.service.ReminderService;

import java.util.List;
/*Данный класс не будет вызываться из других классов, явно. у нас в коде. Но они вызываются на уровне сервера приложений( tomcat). С помощью сервлет менеджера они будут вызываться */

/*(Слой представления) Аннотация для маркировки java класса, как класса контроллера.
Данный класс представляет собой компонент, похожий на обычный сервлет (HttpServlet) (работающий с объектами HttpServletRequest и HttpServletResponse),
 но с расширенными возможностями от Spring Framework.*/

    @RestController // данная анатация говрит о том, что все методы этого контролера будут возвращать json объекты
    public class ReminderController {


    /*инцилизтруем на сервис */
    @Autowired
    private ReminderService service;

        /*т.к методов у нас может быть много. То  данная анатация дает  возможность обратиться к данному методу.говорит о том ,
         как попадать на данный контролер указав в url localhost:8080 /reminders*/
    @RequestMapping(value = "/reminders",method = RequestMethod.GET)
    @ResponseBody // скажет , что в качестве ответа надо вернуть в нашем случае строку
    //Получаем все записи
    public List<Remind> getReminders(){
        return  service.getAll();
    }


        /* Данный метод нужен , чтобы получать какой-нибудь один объект. Например напоминание с id =12*/
        @RequestMapping(value = "/reminders/{id}",method = RequestMethod.GET)
        @ResponseBody
       // public List<Remind> getReminders(@PathVariable long id ){ два варианта задания
        public Remind getReminder(@PathVariable("id") long remindID ){
            return  service.getByID(remindID);
        }


        /* Данный метод нужен , чтобы записывать в нашу бд*/
        @RequestMapping(value = "/reminders",method = RequestMethod.POST)
        @ResponseBody
        public Remind saveReminder(@RequestBody Remind remind){ //анатацией @RequestBody будем принимать целый объект Remind
            /* вернется данный элемент уже с нашим id. И когда мы пришлем сюда элемент на сохранение.
             А там уже будет находиться remind с id. то данный метод его обновит. Поэтому данный метод можно использвать для обновления нашей записи*/
            return  service.save(remind);
        }

        /* Данный метод нужен , чтобы удалять записи из бд*/
        @RequestMapping(value = "/reminders/{id}",method = RequestMethod.DELETE)
        @ResponseBody
        public void delete(@PathVariable long id){
             service.remove(id); // обычно при удалении ничего не возвращаем. Но можно вернуть какой-нибудь модификатор или респоунс
        }




}
