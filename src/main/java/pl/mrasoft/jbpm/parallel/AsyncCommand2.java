package pl.mrasoft.jbpm.parallel;

import org.kie.internal.executor.api.Command;
import org.kie.internal.executor.api.CommandContext;
import org.kie.internal.executor.api.ExecutionResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncCommand2 implements Command {

    private final Logger logger = LoggerFactory.getLogger(AsyncCommand2.class);

    @Override
    public ExecutionResults execute(CommandContext commandContext) throws Exception {

        logger.info("Executing AsyncCommand2");

        return new ExecutionResults();
    }
}
