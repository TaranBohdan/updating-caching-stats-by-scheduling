package com.bohdan.updatestatisticbycache.jwt;

import lombok.Builder;

@Builder
public record AuthenticationResponse (String token) { }
