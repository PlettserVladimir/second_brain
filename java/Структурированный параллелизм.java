import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.Future;

record Weather(String city, double temp) {}
record News(String title) {}

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
        Future<Weather> w = scope.fork(() -> fetchWeather());
        Future<News> n = scope.fork(() -> fetchNews());
        scope.join();
        scope.throwIfFailed();
        System.out.println(w.resultNow() + ", " + n.resultNow());
    }
}