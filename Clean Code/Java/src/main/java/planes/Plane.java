package planes;

import java.util.Objects;

abstract public class Plane {

    private String model;

    private int maxSpeed;

    private int maxFlightDistance;

    private int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance,
            int maxLoadCapacity) {

        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setMaxFlightDistance(int maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
    }

    public void setMaxLoadCapacity(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
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

        Plane plane = (Plane) obj;
        return Objects.equals(model, plane.model)
                && maxSpeed == plane.maxSpeed
                && maxFlightDistance == plane.maxFlightDistance
                && maxLoadCapacity == plane.maxLoadCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(model) + maxSpeed
                + maxFlightDistance + maxLoadCapacity;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getClass().getSimpleName());
        str.append("{model='").append(model).append("', ");
        str.append("maxSpeed=").append(maxSpeed).append(", ");
        str.append("maxFlightDistance=").append(maxFlightDistance).append(", ");
        str.append("maxLoadCapacity=").append(maxLoadCapacity).append("}");
        return str.toString();
    }
}
