package org.apache.fineract.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.fineract.operations.TransactionRequest;
import org.springframework.data.domain.Page;

@Schema(description = "Represent a page of transaction requests")
public class SuccessfulPageTransactionRequest {

    @Schema(description = "page of transaction requests")
    Page<TransactionRequest> transactionRequestsPage;
}
