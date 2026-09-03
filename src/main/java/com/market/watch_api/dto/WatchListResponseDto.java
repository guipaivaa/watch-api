package com.market.watch_api.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WatchListResponseDto(
        List<WatchResponseDto> items,
        long total
) {}