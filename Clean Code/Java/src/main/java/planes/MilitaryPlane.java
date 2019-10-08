package planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private MilitaryType militaryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance,
            int maxLoadCapacity, MilitaryType militaryType) {

        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = militaryType;
    }

    public MilitaryType getMilitaryType() {
        return militaryType;
    }

    public void setMilitaryType(MilitaryType militaryType) {
        this.militaryType = militaryType;
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

        MilitaryPlane militaryPlane = (MilitaryPlane) obj;
        return Objects.equals(militaryType, militaryPlane.militaryType);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hashCode(militaryType);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(", militaryType=").append(militaryType).append("}");
        return super.toString().replace("}", str.toString());
    }
}
