package Controllers;

import Commons.FuncValidation;
import Models.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class MainController {
    private static VillaDAOImpl villaDAO = new VillaDAOImpl();
    private static HouseDAOImpl houseDAO = new HouseDAOImpl();
    private static RoomDAOImpl roomDAO = new RoomDAOImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("\n1.Add New Services.");
        System.out.println("\n2.Show Services.");
        System.out.println("\n3.Exit.");
        System.out.println("\nPlease select one function below: ");
        switch (sc.nextInt()) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;

            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                backMainMenu();
                break;
        }

    }

    private static void addNewServices() {
        System.out.println("\n---------------------------------------------");
        System.out.println("\n1.Add New Villa." +
                "\n2.Add New House." +
                "\n3.Add New Room." +
                "\n4.Back to Menu." +
                "\n5.Exit.");
        System.out.println("\nPlease select one function below: ");
        switch (sc.nextInt()) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                displayMainMenu();
                System.out.println("\n---------------------------------------------");
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                backMainMenu();
                break;
        }
    }

    private static void showServices() {
        System.out.println("\n---------------------------------------------");
        System.out.println("\n1.Show All Villa." +
                "\n2.Show All House." +
                "\n3.Show All Room." +
                "\n4.Back to Menu." +
                "\n5.Exit.");
        System.out.println("\nPlease select one function below: ");
        switch (sc.nextInt()) {
            case 1:
                showVilla();
                break;
            case 2:
                showHouse();
                break;
            case 3:
                showRoom();
                break;
            case 4:
                displayMainMenu();
                System.out.println("\n---------------------------------------------");
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                backMainMenu();
                break;
        }
    }

    private static void showVilla() {
        ArrayList<Villa> listVilla = villaDAO.GetListVillas();
        for (Villa villa : listVilla) {
            System.out.println("\n---------------------------------------------");
            System.out.println(villa.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        backMainMenu();
    }

    private static void showHouse() {
        ArrayList<House> listHouse = houseDAO.GetListHouses();
        for (House house : listHouse) {
            System.out.println("\n---------------------------------------------");
            System.out.println(house.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        backMainMenu();
    }

    private static void showRoom() {
        ArrayList<Room> listRoom = roomDAO.GetListRooms();
        for (Room room : listRoom) {
            System.out.println("\n---------------------------------------------");
            System.out.println(room.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        backMainMenu();
    }

    private static Services addNewService(Services services) {
        String content ="";
        String errMes = "";
        // get UUID
        services.setId(UUID.randomUUID().toString().replace("-", ""));
        sc.nextLine();

        //Enter Name Services
        System.out.println("Enter Name Services: ");
        services.setNameService(sc.nextLine());
        while (!FuncValidation.checkNameServices(services.getNameService())) {
            System.out.println("Name services is invalid. Please try again !!!");
            System.out.println("Enter Name Services: ");
            services.setNameService(sc.nextLine());
        }
        //Enter Area Used
        content = "Enter Area Used: ";
        errMes = "Area Used is invalid (Area > 30, Area must be a Integer). Please try again!!!";
        services.setAreaUsed(FuncValidation.checkValidNumberInteger(content,errMes));
        while (services.getAreaUsed() <= 30){
            System.out.println(errMes);
            services.setAreaUsed(FuncValidation.checkValidNumberInteger(content,errMes));
        }
        //Enter Rental Costs
        content = "Enter Rental Costs: ";
        errMes = "Rental Costs is invalid (Area > 0, Area must be Double). Please try again!!!";
        services.setRentalCosts(FuncValidation.checkValidNumberDouble(content,errMes));
        while (services.getRentalCosts() <= 0){
            System.out.println(errMes);
            services.setRentalCosts(FuncValidation.checkValidNumberDouble(content,errMes));
        }
        //Enter Max Number Of People
        content = "Enter Max Number Of People: ";
        errMes = "Max Number Of People is invalid. Please try again!!!";
        services.setMaxNumberOfPeople(FuncValidation.checkValidNumberInteger(content,errMes));
        sc.nextLine();
        System.out.println("Enter Type Rent: ");
        services.setTypeRent(sc.nextLine());
        return services;
    }

    private static void addNewVilla() {
        Services villa = new Villa();
        villa = addNewService(villa);
        System.out.println("Enter Room Standard: ");
        ((Villa) villa).setRoomStandard(sc.nextLine());
        System.out.println("Enter Convenient Description: ");
        ((Villa) villa).setConvenientDescription(sc.nextLine());
        System.out.println("Area Pool: ");
        ((Villa) villa).setAreaPool(sc.nextDouble());
        System.out.println("Number Of Floors: ");
        ((Villa) villa).setNumberOfFloors(sc.nextInt());
        villaDAO.AddNewVilla((Villa) villa);
        System.out.println("\nAdd Villa: " + villa.getNameService() + " Successfully");
        backMainMenu();
    }

    private static void addNewHouse() {
        Services house = new House();
        house = addNewService(house);
        System.out.println("Enter Room Standard: ");
        ((House) house).setRoomStandard(sc.nextLine());
        System.out.println("Enter Convenient Description: ");
        ((House) house).setConvenientDescription(sc.nextLine());
        System.out.println("Number Of Floors: ");
        ((House) house).setNumberOfFloors(sc.nextInt());
        houseDAO.AddNewHouse((House) house);
        System.out.println("\nAdd House: " + house.getNameService() + " Successfully");
        backMainMenu();
    }

    private static void addNewRoom() {
        Services room = new Room();
        room = addNewService(room);
        System.out.println("Enter Free Services: ");
        ((Room) room).setFreeService(sc.nextLine());
        roomDAO.AddNewRoom((Room) room);
        System.out.println("\nAdd Room: " + room.getNameService() + " Successfully");
        backMainMenu();
    }

    private static void backMainMenu() {
        System.out.println("\nEnter to continue...");
        sc.nextLine();
        sc.nextLine();
        System.out.println("\n---------------------------------------------");
        displayMainMenu();
    }
}
