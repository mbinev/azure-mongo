package app.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoConnector {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping
    private void test() {
        User user = new User();
        user.setName("Jack");
        mongoTemplate.save(user, "user");
        user = mongoTemplate.findOne(
                Query.query(Criteria.where("name").is("Jack")), User.class);
        user.setName("Jim");
        mongoTemplate.save(user, "user");
    }
}
