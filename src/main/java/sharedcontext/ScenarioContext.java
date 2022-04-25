package sharedcontext;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object>  scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(@NotNull ContextStorage key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(@NotNull ContextStorage key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(@NotNull ContextStorage key){
        return scenarioContext.containsKey(key.toString());
    }
}
