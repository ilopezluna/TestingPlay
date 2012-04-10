package controllers;

import models.User;
import play.data.Form;
import play.mvc.*;
import views.html.index;

public class Application extends Controller {

    static Form<User> userForm = form(User.class);

    public static Result index() {
        //return ok(index.render("Your new application is ready."));
        return redirect(routes.Application.users());
    }
    public static Result users() {
        return ok(
                views.html.index.render(User.all(), userForm)
        );
    }

    public static Result newUser() {
        Form<User> filledForm = userForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.index.render(User.all(), filledForm)
            );
        } else {
            User.create(filledForm.get());
            return redirect(routes.Application.users());
        }
    }

    public static Result deleteUser(Long id) {
        User.delete(id);
        return redirect(routes.Application.users());
    }
  
}