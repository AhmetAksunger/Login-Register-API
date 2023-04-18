package ahmetaksunger.loginRegister.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCreatedByResponse {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private Date createDate;
    private Date modifiedDate;
    private String createdBy;

}
