package planes;

import java.util.Objects;
import models.ClassificationLevel;
import models.ExperimentalType;

public class ExperimentalPlane extends Plane {

    private ExperimentalType experimentalType;

    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance,
            int maxLoadCapacity, ExperimentalType experimentalType,
            ClassificationLevel classificationLevel) {

        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setExperimentalType(ExperimentalType experimentalType) {
        this.experimentalType = experimentalType;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
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

        ExperimentalPlane experimentalPlane = (ExperimentalPlane) obj;
        return Objects.equals(experimentalType, experimentalPlane.experimentalType)
                && Objects.equals(classificationLevel,
                        experimentalPlane.classificationLevel);
    }

    @Override
    public int hashCode() {
        return super.hashCode()
                + Objects.hash(experimentalType, classificationLevel);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(", experimentalType=").append(experimentalType).append(", ");
        str.append("classificationLevel=").append(classificationLevel).append("}");
        return super.toString().replace("}", str.toString());
    }
}
