package planes;

public class PassengerPlane extends Plane {

    private int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance,
            int maxLoadCapacity, int passengersCapacity) {

        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }

        PassengerPlane passengerPlane = (PassengerPlane) obj;
        return passengersCapacity == passengerPlane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + passengersCapacity;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(", passengersCapacity=").append(passengersCapacity).append("}");
        return super.toString().replace("}", str.toString());
    }
}
