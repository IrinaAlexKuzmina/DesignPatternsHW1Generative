public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                //.setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

        System.out.println("Мы знаем возраст " + son + "? " + son.hasAge());
        System.out.println("Мы знаем возраст " + mom + "? " + mom.hasAge());

        if (son.hasAge()) {
            System.out.println("Возраст " + son + " = " + son.getAge().getAsInt());
            son.happyBirthday();
            System.out.println("С Днем Рождения " + son + ", тебе исполнилось " + son.getAge().getAsInt());
        }

        System.out.println("Мы знаем адрес " + son + "? " + son.hasAddress());
        System.out.println("Мы знаем адрес " + mom + "? " + mom.hasAddress());
        System.out.println("Адрес " + son + ": " + son.getAddress());
        System.out.println("Адрес " + mom + ": " + mom.getAddress());

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}