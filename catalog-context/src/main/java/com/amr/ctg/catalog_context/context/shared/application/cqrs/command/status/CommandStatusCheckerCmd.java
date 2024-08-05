package com.amr.ctg.catalog_context.context.shared.application.cqrs.command.status;

import com.amr.cmc.common_context.bus.command.IRequestCommand;

public record CommandStatusCheckerCmd(String message) implements IRequestCommand {

}