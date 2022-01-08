package com.yuki.experiment.framework.socket;

import com.yuki.experiment.framework.entity.Practice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSocket {

    private WebSocketServer webSocketServer;

    private Integer correctNum;

    private Practice practice;
}
