import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student1 = new Student("Эдуард Кузьмин", 19, 3.42);

        System.out.println("Поля объекта Student до сериализации:");
        System.out.println(student1);
        System.out.println();

        // Сериализация объекта Student в файл
        try (FileOutputStream fileOutputStream = new FileOutputStream("student1.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
            objectOutputStream.writeObject(student1);
            System.out.println("Объект Student сериализован.");
        }

        // Десериализация объекта Student из файла
        try (FileInputStream fileInputStream = new FileInputStream("student1.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
        {
            student1 = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован.");
        }

        System.out.println();
        System.out.println("Поля объекта Student после десериализации:");
        System.out.println(student1);
        System.out.println();

        System.out.println("Значение GPA не было сохранено и восстановлено, потому что" + "\n" +
                "поле GPA было исключено из процесса сериализации благодаря " + "\n" +
                "модификатору transient, т.е. не было сохранено в файле student1.bin");

    }
}