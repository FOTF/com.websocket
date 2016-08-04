package org.springframework.samples.websocket.config;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.socket.sockjs.transport.handler.DefaultSockJsService;

/**
 * Created by 宗祥 on 2016/8/4.
 */
public class MyDefaultSockJsService extends DefaultSockJsService {

    public MyDefaultSockJsService(TaskScheduler scheduler) {
        super(scheduler);
    }
}
