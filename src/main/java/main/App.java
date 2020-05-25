package main;

import entities.property.PropertyDao;
import entities.propertyType.PropertyType;
import entities.propertyType.PropertyTypeDAO;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter property name:");
        String name = input.nextLine();
        System.out.println("Enter description:");
        String description = input.nextLine();
        System.out.println("Now address");
        System.out.println("Enter the road :");
        String road = input.nextLine();
        System.out.println("Enter the district:");
        String district = input.nextLine();
        System.out.println("Enter the city:");
        String city = input.nextLine();
        System.out.println("Enter the zip code:");
        String zip = input.nextLine();
        System.out.println("Enter the country:");
        String country = input.nextLine();
        System.out.println("Now its time for few more details :)");
        System.out.println("Enter property phone number:");
        String phone = input.nextLine();
        System.out.println("Enter property email:");
        String email = input.nextLine();
        System.out.println("What is your CHECK IN time:");
        String checkIn = input.nextLine();
        System.out.println("What is your CHECK OUT time:");
        String checkOut = input.nextLine();

        PropertyDao.insert(name, description, road, district, city, zip
        ,country, phone, email, checkIn, checkOut);
    }
}
