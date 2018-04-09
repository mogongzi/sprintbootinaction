package demo.springboot.batch.process;

import demo.springboot.batch.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process(Person item) throws ValidationException {
        super.process(item);

        if(item.getNation().equals("han")) {
            item.setNation("01");
        } else {
            item.setNation("02");
        }

        return item;
    }
}
