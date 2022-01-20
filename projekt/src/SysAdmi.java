import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SysAdmi extends JFrame{

    static Pracownik[] database = new Pracownik[100];

    public static void main(String[] args) {

        Pracownik gracjan = new Pracownik("Gracjan", "Piotrowski", 1979, "Asystent", 3620);
        Pracownik edward = new Pracownik("Edward", "Laskowski", 1982, "Administrator Sieci", 3110);
        Pracownik ignacy = new Pracownik("Ignacy", "Makowski", 1990, "Analityk Finansowy", 3850);
        Pracownik anastazy = new Pracownik("Anastazy", "Błaszczyk", 1999, "Administrator Sieci", 3000);
        Pracownik fabian = new Pracownik("Fabian", "Zalewski", 1997, "Dyrektor", 3205);
        Pracownik alex = new Pracownik("Alex", "Szewczyk", 1972, "Dyrektor", 3350);
        Pracownik aneta = new Pracownik("Aneta", "Sikora", 1999, "Kierownik", 3150);
        Pracownik marlena = new Pracownik("Marlena", "Przybylska", 1980, "Technik", 3230);
        Pracownik bartek = new Pracownik("Bartosz", "Błaszczyk", 1992, "Technik", 3160);
        Pracownik roksana = new Pracownik("Roksana", "Witkowska", 1998, "Informatyk", 2720);
        Pracownik robert = new Pracownik("Robert", "Kowalski", 1981, "Informatyk", 2640);
        Pracownik adam = new Pracownik("Adam", "Nowak", 1985, "Informatyk", 2810);
        Pracownik ania = new Pracownik("Anna", "Maczek", 1999, "Kierownik", 3210);

        addDatabase(marlena);
        addDatabase(adam);
        addDatabase(ania);
        addDatabase(anastazy);
        addDatabase(roksana);
        addDatabase(robert);
        addDatabase(bartek);
        addDatabase(aneta);
        addDatabase(alex);
        addDatabase(ignacy);
        addDatabase(edward);
        addDatabase(gracjan);
        addDatabase(fabian);

        startWindow();
    }

    public static void startWindow(){
        final JFrame frame = new JFrame("System Administracyjny");
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new GridLayout(8, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel opcje = new JLabel("Wybierz Opcje: ");
        JButton button1 = new JButton("Wyszukaj informacje o pracowniku");
        JButton button2 = new JButton("Pokaż Wszystkich");
        JButton button3 = new JButton("Oblicz wiek pracownika");
        JButton button4 = new JButton("Średnia pensja pracowników");
        JButton button5 = new JButton("Top 10 średnia pensja");
        JButton button6 = new JButton("Sortowanie względem wieku");
        JButton button7 = new JButton("Zapis Dane");

        startPanel.add(opcje);
        startPanel.add(button1);
        startPanel.add(button2);
        startPanel.add(button3);
        startPanel.add(button4);
        startPanel.add(button5);
        startPanel.add(button6);
        startPanel.add(button7);

        startPanel.setPreferredSize(new Dimension(500,300));

        JPanel pan2 = new JPanel();
        pan2.add(startPanel);
        frame.add(pan2);
        frame.setSize(550,350);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie;
                String nazwisko;
                String info;
                JTextField imieField = new JTextField(15);
                JTextField nazwiskoField = new JTextField(15);
                JPanel option1 = new JPanel();
                option1.add(new JLabel("Podaj imie: "));
                option1.add(imieField);
                option1.add(new JLabel("Podaj Nazwisko: "));
                option1.add(nazwiskoField);

                int result = JOptionPane.showConfirmDialog(null, option1,"Szukaj Pracownika", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION){
                    imie = imieField.getText();
                    nazwisko = nazwiskoField.getText();

                    if (checkDatabase(imie, nazwisko) != 51) {
                        info = database[checkDatabase(imie, nazwisko)].toString();

                        String[] options = new String[]{"Wróć do menu", "OK"};

                        int option = JOptionPane.showOptionDialog(null, info, "Dane Pracownika",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                null, options, options[1]);

                        if (option == 0) {
                            startWindow();
                        }
                    } else {
                        JLabel wrong = new JLabel("ERROR: Brak pracownika w bazie danych");
                        String[] options = new String[]{"Wróć do menu", "Ok"};

                        int option = JOptionPane.showOptionDialog(null, wrong, "Error", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.ERROR_MESSAGE, null, options, options[1]);

                        if (option == 0) {
                            startWindow();
                        }
                    }
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] list = new String[100];
                list[0] =  " ";

                for (int i = 0; i < database.length; i++) {
                    if (database[i] != null) {
                        list[i +1] = database[i].toString();
                    }
                }

                JList<String> listaList = new JList<String>(list);

                JScrollPane sc = new JScrollPane(listaList);

                String[] options = new String[]{"Wróć do menu", "OK"};

                int option = JOptionPane.showOptionDialog(null, sc, "Frimowe Informacje",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

                if (option == 0){
                    startWindow();
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie;
                String nazwisko;
                String info;
                JTextField imieField = new JTextField(15);
                JTextField nazwiskoField = new JTextField(15);
                JPanel option2 = new JPanel();
                option2.add(new JLabel("Podaj imime: "));
                option2.add(imieField);
                option2.add(new JLabel("Podaj nazwisko: "));
                option2.add(nazwiskoField);

                int result = JOptionPane.showConfirmDialog(null, option2, "Oblicz wiek", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION){
                    imie = imieField.getText();
                    nazwisko = nazwiskoField.getText();

                    if (checkDatabase(imie, nazwisko) != 51){
                        info = String.valueOf(2022 - database[checkDatabase(imie, nazwisko)].getRok_Urodzenia());

                        String[] options = new String[]{"Wróć do Menu", "OK"};

                        int option = JOptionPane.showOptionDialog(null, info, "Wiek", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

                        if (option == 0) {
                            startWindow();
                        }
                    } else  {
                        JLabel wrong = new JLabel("ERROR: Brak pracownika w bazie danych");
                        String[] options = new String[]{"Wróć do menu", "Ok"};

                        int option = JOptionPane.showOptionDialog(null, wrong, "Error", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.ERROR_MESSAGE, null, options, options[1]);

                        if (option == 0) {
                            startWindow();
                        }
                    }
                }

            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String imie;
                String nazwisko;
                String info;
                JTextField imieField = new JTextField(15);
                JTextField nazwiskoField = new JTextField(15);
                JPanel option2 = new JPanel();
                option2.add(new JLabel("Podaj imime: "));
                option2.add(imieField);
                option2.add(new JLabel("Podaj nazwisko: "));
                option2.add(nazwiskoField);

                int result = JOptionPane.showConfirmDialog(null, option2, "Średnia placa dzienna", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION){
                    imie = imieField.getText();
                    nazwisko = nazwiskoField.getText();

                    if (checkDatabase(imie, nazwisko) != 51){
                        info = String.valueOf(database[checkDatabase(imie, nazwisko)].getWyplata()/30);

                        String[] options = new String[]{"Wróć do Menu", "OK"};

                        int option = JOptionPane.showOptionDialog(null, info, "Średnia placa dzienna", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

                        if (option == 0) {
                            startWindow();
                        }
                    } else  {
                        JLabel wrong = new JLabel("ERROR: Brak pracownika w bazie danych");
                        String[] options = new String[]{"Wróć do menu", "Ok"};

                        int option = JOptionPane.showOptionDialog(null, wrong, "Error", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.ERROR_MESSAGE, null, options, options[1]);

                        if (option == 0) {
                            startWindow();
                        }
                    }
                }

            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int[] intArray = new int[100];
                for (int i = 0; i < database.length; i++) {
                    if (database[i] != null){
                        intArray[i+1] = (database[i].getWyplata())/30;
                    }
                }

                Arrays.sort(intArray);

                int odwrotnie[] = new int[intArray.length];

                for (int i = intArray.length - 1; i > 0;) {
                    for (int j = 0; j < intArray.length; j++) {
                        odwrotnie[j] = intArray[i];
                        i--;
                    }
                }

                String[] strArray = new String[100];
                strArray[0] = " ";

                for (int i = 0; i < 10; i++) {
                    if (odwrotnie[i] != 0){
                        strArray[i] = String.valueOf(odwrotnie[i]);
                    }
                }

                JList<String> listaList = new JList<String>(strArray);

                JScrollPane sc = new JScrollPane(listaList);

                String[] options = new String[]{"Wróć do menu", "OK"};

                int option = JOptionPane.showOptionDialog(null, sc, "Frimowe Informacje",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

                if (option == 0){
                    startWindow();
                }
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] intArray = new int[100];
                for (int i = 0; i < database.length; i++) {
                    if (database[i] != null){
                        intArray[i+1] = database[i].getRok_Urodzenia();
                    }
                }

                Arrays.sort(intArray);

                String[] strArray = new String[100];
                strArray[0] = " ";

                for (int i = 0; i < intArray.length; i++) {
                    if (intArray[i] != 0){
                        strArray[i] = String.valueOf(intArray[i]);
                    }
                }

                JList<String> listaList = new JList<String>(strArray);


                JScrollPane sc = new JScrollPane(listaList);

                String[] options = new String[]{"Wróć do menu", "OK"};

                int option = JOptionPane.showOptionDialog(null, sc, "Frimowe Informacje",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

                if (option == 0){
                    startWindow();
                }
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String list2 = "Informacje o Wszystkich Pracownikach: \n";

                try{
                    for (int i = 0; i < database.length; i++) {
                        if (database[i] != null){
                            list2 += "\n \n" + database[i].toString();
                        }
                    }
                    FileOutputStream file = new FileOutputStream("Dane");

                    file.write(list2.getBytes());
                } catch (IOException k){
                    System.err.println("IO Exception handlled");
                }

                String message = "Informacje zostały zapisane w pliku 'Dane'";
                String[] options = new String[]{"Wróć do menu", "OK"};

                int option = JOptionPane.showOptionDialog(null, message, "Informacja", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

                if (option == 0){
                    startWindow();
                }
            }
        });
    }


    public static void addDatabase(Pracownik add) throws ArrayIndexOutOfBoundsException {
        boolean added = false;
        int x = 0;

        try {
            while (added == false) {
                if (database[x] == null) {
                    database[x] = add;
                    added = true;
                    break;
                } else {
                    x++;
                    added = false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            Pracownik[] temp = new Pracownik[database.length * 2];

            int index = 0;
            for (int y = 0; y < database.length; y++) {
                index = y;
                temp[y] = database[y];
            }

            temp[index + 1] = add;
            database = temp;
            System.err.println("");

        }

    }

    public static int checkDatabase(String imie, String nazwisko) {
        int exists = 51;
        for (int x = 0; x < database.length; x++) {
            if (database[x] != null) {
                if (imie.equals(database[x].getImie()) && nazwisko.equals(database[x].getNazwisko())) {
                    exists = x;
                    break;
                }
            }
        }

        return exists;
    }

    public static int checkDatabase2(String wyplata) {
        int exists = 51;
        for (int x = 0; x < database.length; x++) {
            if (database[x] != null) {
                if (wyplata.equals(database[x].getWyplata())) {
                    exists = x;
                    break;
                }
            }
        }

        return exists;
    }

}
