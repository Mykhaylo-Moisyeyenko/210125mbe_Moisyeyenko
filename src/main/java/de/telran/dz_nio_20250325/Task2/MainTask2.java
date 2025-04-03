package de.telran.dz_nio_20250325.Task2;

//2)* Реализуйте механизм сохранения и чтения объекта Client в файл.
//Вот приблизительно наполнение класса Client.
//private Long id;
//private String status;
//private Long taxCode;
//private String firstName;
//private String lastName;
//private String email;
//private String address;
//private String phone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainTask2 {

    public static void main(String[] args) {

        Client client = new Client(12345L, "active", 67890L, "John", "Smith", "mama@gmail.com", "Toronto", "123456789");
        String string = clientToText(client);

        Path path = Path.of("client.txt");

        try {
            Files.write(path, string.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Проверка - прочитаю некоторые данные из созданного файла:
        Path path2 = Path.of("client.txt");
        Client client1 = textToClient(path2);
        System.out.println(client1.getId() +" " + client1.getLastName() + " " + client1.getEmail());

    }

    public static String clientToText(Client client) {
        return client.getId() + ";" + client.getStatus() + ";" + client.getTaxCode() + ";" + client.getFirstName() + ";" + client.getLastName() + ";" + client.getEmail() + ";" + client.getAddress() + ";" + client.getPhone();
    }

    public static Client textToClient(Path path) {
        try {
            List<String> list = Files.readAllLines(path);
            String lines = list.get(0);
            String[] val = lines.split(";");

            Long id = Long.parseLong(val[0]);
            String status = val[1];
            Long taxCode = Long.parseLong(val[2]);
            String firstName = val[3];
            String lastName = val[4];
            String email = val[5];
            String address = val[6];
            String phone = val[7];

            return new Client (id, status, taxCode, firstName, lastName, email,address, phone);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
