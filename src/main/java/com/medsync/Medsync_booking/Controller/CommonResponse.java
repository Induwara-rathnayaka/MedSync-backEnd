package com.medsync.Medsync_booking.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CommonResponse {
    private String status;
    private String message;
    private Object data;
}
