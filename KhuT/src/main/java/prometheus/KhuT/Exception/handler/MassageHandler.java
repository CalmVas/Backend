package prometheus.KhuT.Exception.handler;


import prometheus.KhuT.Common.BaseErrorCode;
import prometheus.KhuT.Exception.GeneralException;

public class MassageHandler extends GeneralException {
    public MassageHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
