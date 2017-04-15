package ru.success.MyFirstServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.success.MyFirstServer.entity.Remind;

/*нужен для того, чтобы работать с нашей таблицей в базе данных, оперируя java объектами .  в нашем случае remind object*/
/*первый параметр отвечает за возвращаемый объект, второй за тип сущности, в нашем случае это long, поэтому указываем оберточный Long*/
public interface RemindRepository extends JpaRepository<Remind,Long> {


}
