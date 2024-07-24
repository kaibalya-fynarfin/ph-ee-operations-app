package org.apache.fineract.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.fineract.operations.TransferResponse;
import org.springframework.data.domain.Page;

@Schema(description = "represents a page of tranfer responses")
public class SuccessfulPageTransferResponse {

    @Schema(description = "page of tranfer responses")
    Page<TransferResponse> transferReponsesPage;

}
