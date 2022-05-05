# app

## Межпроцессный обмен в микросервисной архитектуре

### Используемый стек
SpringBoot, SprincMVC, SpringJPA, RabbitMQ, DB H2 или же обычная коллекция в памяти

### Описание
1) Клиент может выполнять два метода: http post для сохранения клиента и http get для получения информации по клиентам
2) Первое приложение реализует два метода:
 a) Создание клиента HTTP POST
  http://localhost:8181/addClient
  {
   "status": active,
   "FIO": "Ivanov Ivan Ivanovich"
  }
  
 b) Получение всех клиентов HTTP GET:
  http://localhost:8181/getClients
3) После получения информации, десирализуем данные в объект и отправляем его через rabbitmq второму приложению
4) Второе приложение принимает сообщение и сохраняет в базу данных или же получает данные из БД(в зависимости от сообщение сохраняем клиента или же получаем всех клиентов)
5) Приложение спроектировать таким образом, чтобы можно было заменить базу данных на коллекцию объектов
6) Вернуть полученный результат клиенту
7) Тип асинхронной очереди - Request/response
8) Для взаимодействия с rabbitmq можно использовать spring aqmp или же spring cloud connector( на усмотрение)
 
