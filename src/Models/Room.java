package Models;

public class Room extends Services {
    private String freeService;

    public Room(String id, String nameService, double areaUsed, double rentalCosts, int maxNumberOfPeople, String typeRent, String freeService) {
        super(id, nameService, areaUsed, rentalCosts, maxNumberOfPeople, typeRent);
        this.freeService = freeService;
    }

    public Room() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInfor() {
        return "\nId Service: " + super.getId() +
                "\nName Service: " + super.getNameService() +
                "\nArea Used: " + super.getAreaUsed() +
                "\nRental Costs: " + super.getRentalCosts() +
                "\nMax Number Of People: " + super.getMaxNumberOfPeople() +
                "\nType Rent: " + super.getTypeRent() +
                "\nRoom Standard: " + this.freeService;
    }
}
