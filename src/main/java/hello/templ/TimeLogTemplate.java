package hello.templ;

public class TimeLogTemplate {

    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();
        //비지니스 로직 실행
        //핵심 기능
        callback.call();
        //비지니스 로직 종료

        //부가 기능
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("비지니스 로직1 실행 시간 : " + resultTime);
    }
}
