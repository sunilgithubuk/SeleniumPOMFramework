package testData;


import cucumber.api.java.eo.Se;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRegistrationRequest {


        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private String address1;
        private String city;
        private String postcode;
        private String phone_mobile;
        private String company;
        private String state;
}
