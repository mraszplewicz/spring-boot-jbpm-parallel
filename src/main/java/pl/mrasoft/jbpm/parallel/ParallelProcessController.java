package pl.mrasoft.jbpm.parallel;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.EmptyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parallel")
public class ParallelProcessController {

    @Autowired
    private RuntimeManager runtimeManager;

    @RequestMapping("/start")
    public void startProcess() {

        getKieSession().startProcess("defaultPackage.sample");
    }

    private KieSession getKieSession() {
        RuntimeEngine runtimeEngine = runtimeManager.getRuntimeEngine(EmptyContext.get());
        KieSession ksession = runtimeEngine.getKieSession();

        return ksession;
    }

}
