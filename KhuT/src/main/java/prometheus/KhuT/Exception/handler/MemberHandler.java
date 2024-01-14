package prometheus.KhuT.Exception.handler;


import prometheus.KhuT.Common.BaseErrorCode;
import prometheus.KhuT.Exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
