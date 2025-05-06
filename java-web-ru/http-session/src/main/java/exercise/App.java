package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            List<Map<String, String>> userList  = new ArrayList<>();
            
            for (var iStep = page * per - per; iStep < page * per; iStep++) {
                userList.add(USERS.get(iStep));
            }
            ctx.json(userList);
            /*
            по индексу пользователя без сортировки
            ctx.json(USERS.stream()
                .filter(map -> Integer.parseInt(map.get("id")) >= page * per - per + 1
                    && Integer.parseInt(map.get("id")) <= page * per)
                .toList()
            );
            */
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
