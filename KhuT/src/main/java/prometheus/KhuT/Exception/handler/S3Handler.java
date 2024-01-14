package prometheus.KhuT.Exception.handler;


import prometheus.KhuT.Common.BaseErrorCode;
import prometheus.KhuT.Exception.GeneralException;

public class S3Handler extends GeneralException {
  public S3Handler(BaseErrorCode baseErrorCode) {
    super(baseErrorCode);
  }
}
