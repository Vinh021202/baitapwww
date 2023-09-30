package convertes;

import enums.EmployeeStatus;
import jakarta.persistence.AttributeConverter;

public class EmployeeStatusConverter  implements AttributeConverter<EmployeeStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if (attribute == null)
            return null;

        return attribute.getStatus();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer Data) {
        if (Data == 1)
            return EmployeeStatus.WORKING;
        if (Data == 0)
            return EmployeeStatus.UN_WORKING;
        if (Data == -1)
            return EmployeeStatus.QUITTED;
        return null;
    }

}
