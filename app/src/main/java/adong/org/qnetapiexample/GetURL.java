package adong.org.qnetapiexample;

/**
 * Created by user011 on 2018-03-11.
 */

public class GetURL {
    public static final String baseURL = "http://openapi.q-net.or.kr";

    public static final String suportURL = "/api/service/rest/InquiryTestInformationNTQSVC/";

    public static final String servicekey = "XgEUt3mfkuKJFIgseJbCwzCzYpYXX0Zvpf0GsVffrhMFyez0tFfeJiaPWAbL2UxLnh7fagSw%2FjNeRQJcvG9T7w%3D%3D&_type=json";

    //기술사 시험
    public static final String PEListURL = "getPEList?serviceKey=";

    //기능사 시험
    public static final String CListURL = "getCList?serviceKey=";

    //기능장 시험
    public static final String MCListURL = "getMCList?serviceKey=";

    //기사, 산업기사 시험
    public static final String EListURL = "getEList?serviceKey=";

    //종목별 수수료
    public static final String FeeListURL = "getFeeList?serviceKey=";

    //종목별 시험 일정
    public static final String JMListURL = "getJMList?serviceKey=";
}
