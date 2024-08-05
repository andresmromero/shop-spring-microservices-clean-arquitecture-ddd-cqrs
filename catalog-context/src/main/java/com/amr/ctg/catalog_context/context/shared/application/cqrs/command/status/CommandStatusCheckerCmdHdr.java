package com.amr.ctg.catalog_context.context.shared.application.cqrs.command.status;

import com.amr.cmc.common_context.bus.command.ICommandHandler;
import com.amr.ctg.catalog_context.context.shared.application.port.input.ICommandStatusCheckerPort;
import org.springframework.stereotype.Service;

@Service
public class CommandStatusCheckerCmdHdr implements ICommandHandler<CommandStatusCheckerCmd> {

    private final ICommandStatusCheckerPort commandStatusCheckerPort;

    public CommandStatusCheckerCmdHdr(ICommandStatusCheckerPort commandStatusCheckerPort) {

        this.commandStatusCheckerPort = commandStatusCheckerPort;
    }


    @Override
    public void handler(CommandStatusCheckerCmd command) {

        commandStatusCheckerPort.execute(command.message());
    }

}