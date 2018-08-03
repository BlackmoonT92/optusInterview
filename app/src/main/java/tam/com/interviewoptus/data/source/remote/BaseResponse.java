package tam.com.interviewoptus.data.source.remote;

/**
 * Created by tamphan on 03/8/18.
 */
public class BaseResponse<T> {
  int code;

  String status;

  T data;

  public int getCode() {
    return code;
  }

  public String getStatus() {
    return status;
  }

  public T getData() {
    return data;
  }
}
