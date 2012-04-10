package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import static play.data.validation.Constraints.*;

@Entity
public class User extends Model {

    @Id
    public Long id;

    @Required
    public String firstName;

    public static Finder<Long,User> find = new Finder(
            Long.class, User.class
    );

    public static void create(User user) {
        user.save();
    }

    public static List<User> all() {
        return find.all();
    }
    public static void delete(Long id) {
        find.ref(id).delete();
    }
}