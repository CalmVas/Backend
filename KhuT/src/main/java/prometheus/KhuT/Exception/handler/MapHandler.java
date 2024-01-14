package prometheus.KhuT.Exception.handler;


import prometheus.KhuT.Common.BaseErrorCode;
import prometheus.KhuT.Exception.GeneralException;

public class MapHandler extends GeneralException {
  public MapHandler(BaseErrorCode errorCode) {super(errorCode);}
}
