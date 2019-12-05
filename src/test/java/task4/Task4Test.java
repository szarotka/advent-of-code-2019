package task4;

import org.junit.jupiter.api.Test;

class Task4Test {

    @Test
    void findAllPasswords() {
        Task4 task4 = new Task4();
        long count = task4.findAllPasswords();
        System.out.println(count);
    }

    @Test
    void findAllPasswordsWithoutLargerGroups() {
        Task4 task4 = new Task4();
        long count = task4.findAllPasswordsWithoutLargerGroups();
        System.out.println(count);
    }
}