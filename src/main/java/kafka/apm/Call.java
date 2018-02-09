package kafka.apm;

import java.util.Date;


public class Call {

    private String spanId;
    private String callId;
    private int protocol;
    private String callImplement;
    private String callContext;
    private Date csTime;
    private Date crTime;
    private int seq;
    private int status;

    public static enum Protocol {
        HTTP, RPC, MQ;
    }

    public static enum Status {
        SUCCESS, ERROR, TIMEOUT;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public String getCallImplement() {
        return callImplement;
    }

    public void setCallImplement(String callImplement) {
        this.callImplement = callImplement;
    }

    public String getCallContext() {
        return callContext;
    }

    public void setCallContext(String callContext) {
        this.callContext = callContext;
    }

    public Date getCsTime() {
        return csTime;
    }

    public void setCsTime(Date csTime) {
        this.csTime = csTime;
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Call call = (Call) o;

        return spanId.equals(call.spanId) && callId == call.callId;
    }


    @Override
    public int hashCode() {
        int result = spanId.hashCode();
        result = 31 * result + (callId != null ? callId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "spanid:" + spanId + " callid:" + callId + " protocol:" + protocol + " callImplement:" + callImplement + " callContext:" + callContext + " csTime:" + csTime + " crTime:" + crTime + " seq:" + seq + " status:" + status;
    }
}

