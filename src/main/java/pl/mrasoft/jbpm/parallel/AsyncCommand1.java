package pl.mrasoft.jbpm.parallel;

import org.kie.internal.executor.api.Command;
import org.kie.internal.executor.api.CommandContext;
import org.kie.internal.executor.api.ExecutionResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncCommand1 implements Command {

    private final Logger logger = LoggerFactory.getLogger(AsyncCommand1.class);

    @Override
    public ExecutionResults execute(CommandContext commandContext) throws Exception {

        logger.info("Executing AsyncCommand1");

        return new ExecutionResults();
    }
}
