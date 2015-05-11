package pl.mrasoft.jbpm.parallel;


import org.jbpm.executor.impl.wih.AsyncWorkItemHandler;
import org.jbpm.runtime.manager.impl.DefaultRegisterableItemsFactory;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.internal.executor.api.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringRegisterableItemsFactory extends DefaultRegisterableItemsFactory {

    @Autowired
    private ExecutorService executorService;


    @Override
    public Map<String, WorkItemHandler> getWorkItemHandlers(RuntimeEngine runtime) {
        Map<String, WorkItemHandler> handlers = super.getWorkItemHandlers(runtime);
        handlers.put("async", new AsyncWorkItemHandler(executorService));
        return handlers;
    }
}
