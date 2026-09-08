import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.Future;

record Weather(String city, double temperature) {}
record News(String headline) {}

Weather fetchWeather() throws InterruptedException {
    Thread.sleep(200);
    return new Weather("Moscow", 22.5);
}

News fetchNews() throws InterruptedException {
    Thread.sleep(150);
    return new News("Java 25 Released!");
}

void main() throws Exception {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
        Future<Weather> weatherFuture = scope.fork(() -> fetchWeather());
        Future<News> newsFuture = scope.fork(() -> fetchNews());

        scope.join();               // ждём все задачи
        scope.throwIfFailed();      // если ошибка – бросаем исключение

        Weather w = weatherFuture.resultNow();
        News n = newsFuture.resultNow();
        System.out.println("Weather: " + w.temperature() + "°C, News: " + n.headline());
    }
}