package Models;

public class House extends Services{
    private String roomStandard;
    private String convenientDescription;
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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public House() {
    }

    public House(String id, String nameService, double areaUsed, double rentalCosts, int maxNumberOfPeople, String typeRent, String roomStandard, String convenientDescription, int numberOfFloors) {
        super(id, nameService, areaUsed, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfor(){
        return "\nId Service: " + super.getId() +
                "\nName Service: " + super.getNameService() +
                "\nArea Used: " + super.getAreaUsed() +
                "\nRental Costs: " + super.getRentalCosts() +
                "\nMax Number Of People: " +super.getMaxNumberOfPeople() +
                "\nType Rent: " + super.getTypeRent() +
                "\nRoom Standard: "+ this.roomStandard +
                "\nConvenent Description: " + this.convenientDescription +
                "\nNumber Of Floors: " + this.numberOfFloors;
    }
}
