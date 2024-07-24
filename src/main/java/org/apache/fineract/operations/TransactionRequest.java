package org.apache.fineract.operations;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.fineract.organisation.parent.AbstractPersistableCustom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.apache.fineract.operations.TransactionRequestState.IN_PROGRESS;


@Entity
@Table(name = "transaction_requests")
public class TransactionRequest extends AbstractPersistableCustom<Long> {

    @Schema(description = "Workflow instance key associated with the transaction request", example = "2251799816099637")
    @Column(name = "WORKFLOW_INSTANCE_KEY")
    private String workflowInstanceKey;

    @Schema(description = "Transaction identifier", example = "8c2358be640c4BtABNeY")
    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Schema(description = "Timestamp when the transaction started (epoch milliseconds)", example = "1654769838000")
    @Column(name = "STARTED_AT")
    private Date startedAt;

    @Schema(description = "Timestamp when the transaction was completed (epoch milliseconds)", example = "null")
    @Column(name = "COMPLETED_AT")
    private Date completedAt;

    @Schema(description = "State of the transaction request", example = "ACCEPTED")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATE")
    private TransactionRequestState state;

    @Schema(description = "ID of the payee DFSP", example = "null")
    @Column(name = "PAYEE_DFSP_ID")
    private String payeeDfspId;

    @Schema(description = "ID of the payee party", example = "24450523")
    @Column(name = "PAYEE_PARTY_ID")
    private String payeePartyId;

    @Schema(description = "Type of the payee party ID", example = "ACCOUNTID")
    @Column(name = "PAYEE_PARTY_ID_TYPE")
    private String payeePartyIdType;

    @Schema(description = "Fee charged to the payee", example = "null")
    @Column(name = "PAYEE_FEE")
    private BigDecimal payeeFee;

    @Schema(description = "Quote code for the payee", example = "null")
    @Column(name = "PAYEE_QUOTE_CODE")
    private String payeeQuoteCode;

    @Schema(description = "ID of the payer DFSP", example = "null")
    @Column(name = "PAYER_DFSP_ID")
    private String payerDfspId;

    @Schema(description = "ID of the payer party", example = "254708374149")
    @Column(name = "PAYER_PARTY_ID")
    private String payerPartyId;

    @Schema(description = "Type of the payer party ID", example = "MSISDN")
    @Column(name = "PAYER_PARTY_ID_TYPE")
    private String payerPartyIdType;

    @Schema(description = "Fee charged to the payer", example = "null")
    @Column(name = "PAYER_FEE")
    private BigDecimal payerFee;

    @Schema(description = "Quote code for the payer", example = "null")
    @Column(name = "PAYER_QUOTE_CODE")
    private String payerQuoteCode;

    @Schema(description = "Amount of the transaction", example = "1")
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Schema(description = "Currency of the transaction amount", example = "USD")
    @Column(name = "CURRENCY")
    private String currency;

    @Schema(description = "Direction of the transaction", example = "INCOMING")
    @Column(name = "DIRECTION")
    private String direction;

    @Schema(description = "Type of authentication used", example = "null")
    @Column(name = "AUTH_TYPE")
    private String authType;

    @Schema(description = "Type of initiator", example = "BUSINESS")
    @Column(name = "INITIATOR_TYPE")
    private String initiatorType;

    @Schema(description = "Scenario for the transaction", example = "MPESA")
    @Column(name = "SCENARIO")
    private String scenario;

    @Schema(description = "External ID associated with the transaction request", example = "null")
    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Schema(description = "Client correlation ID associated with the transaction request", example = "null")
    @Column(name = "CLIENTCORRELATIONID")
    private String clientCorrelationId;

    @Schema(description = "Error information, if any", example = "null")
    @Column(name = "ERROR_INFORMATION")
    private String errorInformation;

    @Schema(description = "List of variables associated with the transaction request")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionRequest", fetch = FetchType.LAZY)
    private List<Variable> variables;


    @JsonIgnore
    @JsonManagedReference
    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public TransactionRequest() {
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public TransactionRequest(String workflowInstanceKey) {
        this.workflowInstanceKey = workflowInstanceKey;
        this.state = IN_PROGRESS;
    }

    public String getWorkflowInstanceKey() {
        return workflowInstanceKey;
    }

    public void setWorkflowInstanceKey(String workflowInstanceKey) {
        this.workflowInstanceKey = workflowInstanceKey;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public TransactionRequestState getState() {
        return state;
    }

    public void setState(TransactionRequestState state) {
        this.state = state;
    }

    public String getPayeeDfspId() {
        return payeeDfspId;
    }

    public void setPayeeDfspId(String payeeDfspId) {
        this.payeeDfspId = payeeDfspId;
    }

    public String getPayeePartyId() {
        return payeePartyId;
    }

    public void setPayeePartyId(String payeePartyId) {
        this.payeePartyId = payeePartyId;
    }

    public String getPayeePartyIdType() {
        return payeePartyIdType;
    }

    public void setPayeePartyIdType(String payeePartyIdType) {
        this.payeePartyIdType = payeePartyIdType;
    }

    public BigDecimal getPayeeFee() {
        return payeeFee;
    }

    public void setPayeeFee(BigDecimal payeeFee) {
        this.payeeFee = payeeFee;
    }

    public String getPayeeQuoteCode() {
        return payeeQuoteCode;
    }

    public void setPayeeQuoteCode(String payeeQuoteCode) {
        this.payeeQuoteCode = payeeQuoteCode;
    }

    public String getPayerDfspId() {
        return payerDfspId;
    }

    public void setPayerDfspId(String payerDfspId) {
        this.payerDfspId = payerDfspId;
    }

    public String getPayerPartyId() {
        return payerPartyId;
    }

    public void setPayerPartyId(String payerPartyId) {
        this.payerPartyId = payerPartyId;
    }

    public String getPayerPartyIdType() {
        return payerPartyIdType;
    }

    public void setPayerPartyIdType(String payerPartyIdType) {
        this.payerPartyIdType = payerPartyIdType;
    }

    public BigDecimal getPayerFee() {
        return payerFee;
    }

    public void setPayerFee(BigDecimal payerFee) {
        this.payerFee = payerFee;
    }

    public String getPayerQuoteCode() {
        return payerQuoteCode;
    }

    public void setPayerQuoteCode(String payerQuoteCode) {
        this.payerQuoteCode = payerQuoteCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getInitiatorType() {
        return initiatorType;
    }

    public void setInitiatorType(String initiatorType) {
        this.initiatorType = initiatorType;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getClientCorrelationId() {
        return clientCorrelationId;
    }

    public void setClientCorrelationId(String clientCorrelationId) {
        this.clientCorrelationId = clientCorrelationId;
    }

    public String getErrorInformation() {
        return errorInformation;
    }

    public void setErrorInformation(String errorInformation) {
        this.errorInformation = errorInformation;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "workflowInstanceKey='" + workflowInstanceKey + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", startedAt=" + startedAt +
                ", completedAt=" + completedAt +
                ", state=" + state +
                ", payeeDfspId='" + payeeDfspId + '\'' +
                ", payeePartyId='" + payeePartyId + '\'' +
                ", payeePartyIdType='" + payeePartyIdType + '\'' +
                ", payeeFee=" + payeeFee +
                ", payeeQuoteCode='" + payeeQuoteCode + '\'' +
                ", payerDfspId='" + payerDfspId + '\'' +
                ", payerPartyId='" + payerPartyId + '\'' +
                ", payerPartyIdType='" + payerPartyIdType + '\'' +
                ", payerFee=" + payerFee +
                ", payerQuoteCode='" + payerQuoteCode + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", direction='" + direction + '\'' +
                ", authType='" + authType + '\'' +
                ", initiatorType='" + initiatorType + '\'' +
                ", scenario='" + scenario + '\'' +
                ", externalId='" + externalId + '\'' +
                ", clientCorrelationId='" + clientCorrelationId + '\'' +
                ", errorInformation='" + errorInformation + '\'' +
                ", variables=" + variables +
                '}';
    }
}
