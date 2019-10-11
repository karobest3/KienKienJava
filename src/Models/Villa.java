package Models;

public class Villa extends Services {
    private String roomStandard;
    private String convenientDescription;
    private Double areaPool;
    private int numberOfFloors;

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenientDescription() {
        return convenientDescription;
    }

    public void setConvenientDescription(String convenientDescription) {
        this.convenientDescription = convenientDescription;
    }

    public Double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(Double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Villa() {
    }

    public Villa(String id, String nameService, double areaUsed, double rentalCosts, int maxNumberOfPeople, String typeRent, String roomStandard, String convenientDescription, Double areaPool, int numberOfFloors) {
        super(id, nameService, areaUsed, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfor() {
        return "\nId Service: " + super.getId() +
                "\nName Service: " + super.getNameService() +
                "\nArea Used: " + super.getAreaUsed() +
                "\nRental Costs: " + super.getRentalCosts() +
                "\nMax Number Of People: " +super.getMaxNumberOfPeople() +
                "\nType Rent: " + super.getTypeRent() +
                "\nRoom Standard: "+ this.roomStandard +
                "\nConvenent Description: " + this.convenientDescription +
                "\nArea Pool: " + this.areaPool +
                "\nNumber Of Floors: " + this.numberOfFloors;
    }
}
