package net.simon987.server.assembly;


import net.simon987.server.game.objects.ControllableUnit;
import net.simon987.server.io.JSONSerializable;
import net.simon987.server.io.MongoSerializable;
import org.bson.Document;
import org.json.simple.JSONObject;


public abstract class HardwareModule implements MongoSerializable, JSONSerializable {

    private CPU cpu;
    protected ControllableUnit unit;

    public HardwareModule() {

    }

    public HardwareModule(Document document, ControllableUnit unit) {
        this.unit = unit;
    }

    /**
     * Handle an HWI instruction
     */
    public abstract void handleInterrupt(Status status);

    protected CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public abstract char getId();

    @Override
    public String toString() {
        JSONObject hwJson = jsonSerialise();
        return String.format("{%s: {%s}}", getClass().getSimpleName(), hwJson == null ? "" : hwJson);
    }

    public void reset() {

    }

    public void update() {

    }

    @Override
    public JSONObject jsonSerialise() {
        return null;
    }

    @Override
    public JSONObject debugJsonSerialise() {
        return null;
    }

    @Override
    public Document mongoSerialise() {
        Document document = new Document();

        document.put("type", getClass().getCanonicalName());
        return document;
    }
}
