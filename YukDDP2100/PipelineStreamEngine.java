package YukDDP2100;

import java.io.IOException;
import java.util.List;

// TOPICS COVERED: Interface Contracts, Decoupled Architecture //
public interface PipelineStreamEngine {
    void serializeTelemetryStream(List<DeliveryTransaction> dataset, String systemPath) throws IOException;
}