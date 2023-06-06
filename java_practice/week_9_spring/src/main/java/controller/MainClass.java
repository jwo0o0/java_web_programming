package controller;

import model.DAO;

import java.io.FileInputStream;
import java.util.Scanner;

public class MainClass {
    public static void main(String args[]) {
        FileInputStream in;
        try {
            in = new FileInputStream("src/class_settings.txt");
            Scanner aScan = new Scanner(in);
            String className = aScan.nextLine();
            System.out.println("className: " + className);
            aScan.close();
            in.close();

            Class<?> aClass = Class.forName(className);
            DAO dao = (DAO) aClass.getDeclaredConstructor().newInstance();
            dao.extract();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
