package com.aledguedes.shop.eccomerce.dtoResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InTabsResponse {

    private Long id;
    private String tabs;
}
