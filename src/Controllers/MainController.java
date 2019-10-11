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

    public static void DisplayMainMenu() {
        System.out.println("\n1.Add New Services.");
        System.out.println("\n2.Show Services.");
        System.out.println("\n3.Exit.");
        System.out.println("\nPlease select one function below: ");
        switch (sc.nextInt()) {
            case 1:
                AddNewServices();
                break;
            case 2:
                ShowServices();
                break;

            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                BackMainMenu();
                break;
        }

    }

    private static void AddNewServices() {
        System.out.println("\n---------------------------------------------");
        System.out.println("\n1.Add New Villa." +
                "\n2.Add New House." +
                "\n3.Add New Room." +
                "\n4.Back to Menu." +
                "\n5.Exit.");
        System.out.println("\nPlease select one function below: ");
        switch (sc.nextInt()) {
            case 1:
                AddNewVilla();
                break;
            case 2:
                AddNewHouse();
                break;
            case 3:
                AddNewRoom();
                break;
            case 4:
                DisplayMainMenu();
                System.out.println("\n---------------------------------------------");
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                BackMainMenu();
                break;
        }
    }

    private static void ShowServices() {
        System.out.println("\n---------------------------------------------");
        System.out.println("\n1.Show All Villa." +
                "\n2.Show All House." +
                "\n3.Show All Room." +
                "\n4.Back to Menu." +
                "\n5.Exit.");
        System.out.println("\nPlease select one function below: ");
        switch (sc.nextInt()) {
            case 1:
                ShowVilla();
                break;
            case 2:
                ShowHouse();
                break;
            case 3:
                ShowRoom();
                break;
            case 4:
                DisplayMainMenu();
                System.out.println("\n---------------------------------------------");
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                BackMainMenu();
                break;
        }
    }

    private static void ShowVilla() {
        ArrayList<Villa> listVilla = villaDAO.GetListVillas();
        for (Villa villa : listVilla) {
            System.out.println("\n---------------------------------------------");
            System.out.println(villa.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        BackMainMenu();
    }

    private static void ShowHouse() {
        ArrayList<House> listHouse = houseDAO.GetListHouses();
        for (House house : listHouse) {
            System.out.println("\n---------------------------------------------");
            System.out.println(house.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        BackMainMenu();
    }

    private static void ShowRoom() {
        ArrayList<Room> listRoom = roomDAO.GetListRooms();
        for (Room room : listRoom) {
            System.out.println("\n---------------------------------------------");
            System.out.println(room.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        BackMainMenu();
    }

    private static Services AddNewService(Services services) {
        services.setId(UUID.randomUUID().toString().replace("-", ""));
        sc.nextLine();
        try {
            //Enter Name Services
            System.out.println("Enter Name Services: ");
            services.setNameService(sc.nextLine());
            while (!FuncValidation.checkNameServices(services.getNameService())){
                System.out.println("Name services is invalid. Please try again !!!");
                System.out.println("Enter Name Services: ");
                services.setNameService(sc.nextLine());
            }
            //Enter Area Used
            System.out.println("Enter Area Used: ");
            services.setAreaUsed(sc.nextDouble());
            //Enter Rental Costs
            System.out.println("Enter Rental Costs: ");
            services.setRentalCosts(sc.nextDouble());
        }catch (InputMismatchException ex){

        }


        System.out.println("Enter Max Number Of People: ");
        services.setMaxNumberOfPeople(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Type Rent: ");
        services.setTypeRent(sc.nextLine());
        return services;
    }

    private static void AddNewVilla() {
        Services villa = new Villa();
        villa = AddNewService(villa);
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
        BackMainMenu();
    }

    private static void AddNewHouse() {
        Services house = new House();
        house = AddNewService(house);
        System.out.println("Enter Room Standard: ");
        ((House) house).setRoomStandard(sc.nextLine());
        System.out.println("Enter Convenient Description: ");
        ((House) house).setConvenientDescription(sc.nextLine());
        System.out.println("Number Of Floors: ");
        ((House) house).setNumberOfFloors(sc.nextInt());
        houseDAO.AddNewHouse((House) house);
        System.out.println("\nAdd House: " + house.getNameService() + " Successfully");
        BackMainMenu();
    }

    private static void AddNewRoom() {
        Services room = new Room();
        room = AddNewService(room);
        System.out.println("Enter Free Services: ");
        ((Room) room).setFreeService(sc.nextLine());
        roomDAO.AddNewRoom((Room) room);
        System.out.println("\nAdd Room: " + room.getNameService() + " Successfully");
        BackMainMenu();
    }

    private static void BackMainMenu() {
        System.out.println("\nEnter to continue...");
        sc.nextLine();
        sc.nextLine();
        System.out.println("\n---------------------------------------------");
        DisplayMainMenu();
    }
}
