package SunWebOathE2E.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class CustomerDetails {

    private String password;
    private String firstName;
    private String lastName;
    private String email;

}
