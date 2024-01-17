package prometheus.KhuT.Exception.handler;


import prometheus.KhuT.Common.BaseErrorCode;
import prometheus.KhuT.Exception.GeneralException;

public class MassagePlanHandler extends GeneralException {
    public MassagePlanHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
