package org.apache.fineract.operations;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringEscapeUtils;
import org.mifos.connector.common.channel.dto.PhErrorDTO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TransferResponse {

    @Schema(description = "Unique identifier of the transfer", example = "55401")
    private int id;

    @Schema(description = "Workflow instance key associated with the transfer", example = "2251799820950003")
    private Long workflowInstanceKey;

    @Schema(description = "Transaction identifier", example = "e73e4071-5027-4bef-9068-f6b8f0edc595")
    private String transactionId;

    @Schema(description = "Timestamp when the transfer started", example = "null")
    private Date startedAt;

    @Schema(description = "Timestamp when the transfer was completed", example = "1721424204000")
    private Date completedAt;

    @Schema(description = "Status of the transfer", example = "COMPLETED")
    private TransferStatus status;

    @Schema(description = "Detailed status of the transfer", example = "null")
    private String statusDetail;

    @Schema(description = "ID of the payee DFSP", example = "null")
    private String payeeDfspId;

    @Schema(description = "ID of the payee party", example = "000000006")
    private String payeePartyId;

    @Schema(description = "Type of the payee party ID", example = "ACCOUNT_ID")
    private String payeePartyIdType;

    @Schema(description = "Fee charged to the payee", example = "null")
    private BigDecimal payeeFee;

    @Schema(description = "Currency of the payee fee", example = "null")
    private String payeeFeeCurrency;

    @Schema(description = "Quote code for the payee", example = "null")
    private String payeeQuoteCode;

    @Schema(description = "ID of the payer DFSP", example = "null")
    private String payerDfspId;

    @Schema(description = "ID of the payer party", example = "000000005")
    private String payerPartyId;

    @Schema(description = "Type of the payer party ID", example = "ACCOUNT_ID")
    private String payerPartyIdType;

    @Schema(description = "Fee charged to the payer", example = "null")
    private BigDecimal payerFee;

    @Schema(description = "Currency of the payer fee", example = "null")
    private String payerFeeCurrency;

    @Schema(description = "Quote code for the payer", example = "null")
    private String payerQuoteCode;

    @Schema(description = "Amount of the transfer", example = "500")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;

    @Schema(description = "Currency of the transfer amount", example = "USD")
    private String currency;

    @Schema(description = "Direction of the transfer", example = "OUTGOING")
    private String direction;

    @Schema(description = "Error information, if any", example = "null")
    private PhErrorDTO errorInformation;

    @Schema(description = "Batch ID associated with the transfer", example = "null")
    private String batchId;

    @Schema(description = "Client correlation ID associated with the transfer", example = "null")
    private String clientCorrelationId;

    public void parseErrorInformation(String json, ObjectMapper mapper) throws IOException {
        try {
            this.errorInformation = mapper.readValue(json, PhErrorDTO.class);
        } catch (Exception e) {
            try {
                String formattedJson = StringEscapeUtils.unescapeJava(json);
                this.errorInformation = mapper.readValue(formattedJson, PhErrorDTO.class);
            } catch (Exception innerException) {
                this.errorInformation = null;
            }
        }
    }
}
