package hello.threadlocal;

import lombok.Getter;

public class ThreadLocalMain {



    public static void main(String[] args) throws InterruptedException {
    ThreadLocalService threadLocalService = new ThreadLocalService();


    //쓰레드 기능 구현 Runnable 함수형 인터페이스 사용
    //쓰레드 1의 기능 구현 : userA
    Runnable userA = () -> {

        try {
            String result = threadLocalService.save("user_A");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    };

    //쓰레드 2의 기능 구현 : userB
    Runnable userB = () -> {

        try {
            String result = threadLocalService.save("user_B");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    };


    //쓰레드 생성
    Thread threadA = new Thread(userA);
    threadA.setName("thread_A");

    Thread threadB = new Thread(userB);
    threadB.setName("thread_B");


    //쓰레드 실행
    threadA.start();
    Thread.sleep(2000);
    threadB.start();

    //메인 쓰레드 종료 대기
    Thread.sleep(3000);

    }

}
