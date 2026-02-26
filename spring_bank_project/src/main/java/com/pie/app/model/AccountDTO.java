package com.pie.app.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Generated
//@Builder(toBuilder = true)
//@Getter
//@ToString
public class AccountDTO {
    @JsonProperty(value="AccountNo")
    private String accountNo;
    @JsonProperty(value="AccountType")
    private String 	accountType;
    @JsonProperty(value="OpeningDate")
    private LocalDate  openingDate;
    @JsonProperty(value="Balance")
    private double balance;
}
