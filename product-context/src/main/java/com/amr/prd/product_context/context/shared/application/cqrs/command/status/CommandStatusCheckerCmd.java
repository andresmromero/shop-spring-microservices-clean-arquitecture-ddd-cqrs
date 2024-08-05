package com.amr.prd.product_context.context.shared.application.cqrs.command.status;

import com.amr.cmc.common_context.bus.command.IRequestCommand;

public record CommandStatusCheckerCmd(String message) implements IRequestCommand {

}