package ru.live.kamaz_cs;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        MySQLDatabase ms = new MySQLDatabase();
        ms.start();

        ms.addFlat(new Flat("Приморский", "ул. Базовая 30", 22.5, 3, 156000));
        ms.addFlat(new Flat("Молдованка", "ул. Ольгиевский спуск 25", 48, 2, 2564231));
        ms.addFlat(new Flat("Центр", "ул. Пушкинская 44", 55.85, 5, 654315));
        ms.addFlat(new Flat("Таирово", "ул. Сегедская 7", 64, 4, 65464666));
        ms.addFlat(new Flat("Поселок Котовского", "ул. Добровольского 84А", 98, 1, 187435));
        ms.addFlat(new Flat("Поселок Котовского", "ул. Добровольского 84А", 28.2, 2, 181114));
        ms.addFlat(new Flat("Таирово", "ул. Сегедская 3", 14, 1, 654666));
        ms.addFlat(new Flat("Молдованка", "ул. Ольгиевский спуск 2", 55.69, 2, 225831));
        ms.addFlat(new Flat("Молдованка", "ул. Ольгиевский подъем 25", 76.54, 5, 9999854));
        ms.addFlat(new Flat("Приморский", "ул. Бажана 33", 29.98, 1, 6345871));

        ms.chooseParametr();

        ms.closeConnection();


    }

}
