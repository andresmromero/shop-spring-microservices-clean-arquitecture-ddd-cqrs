package com.amr.prd.product_context.context.shared.application.service;

import com.amr.prd.product_context.context.shared.application.port.input.ICommandStatusCheckerPort;
import org.springframework.stereotype.Service;

@Service
public class CommandStatusChecker implements ICommandStatusCheckerPort {

    @Override
    public void execute(String message) {

    }

}