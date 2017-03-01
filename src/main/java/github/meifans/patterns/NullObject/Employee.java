package github.meifans.patterns.NullObject;

import java.util.Date;

/**
 * Created by Meifans on 16/12/15.
 */
public interface Employee {

    boolean timeToPay(Date payDate);

    void pay();

    Employee NULL = new Employee() {
        public boolean timeToPay(Date payDate) {
            return false;
        }

        public void pay() {
        }
    };

}
